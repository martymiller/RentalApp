package com.marty.rentalapp.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.jakewharton.rxbinding4.widget.textChanges
import com.marty.rentalapp.R
import com.marty.rentalapp.databinding.FragmentSearchBinding
import com.marty.rentalapp.di.MAIN_SCHEDULER
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import org.koin.android.ext.android.get
import org.koin.core.KoinComponent
import java.util.concurrent.TimeUnit

class SearchFragment : Fragment(), KoinComponent {

    companion object {
        const val DEBOUNCE_DURATION_MSEC: Long = 500L
    }

    private val viewModel: SearchViewModel by activityViewModels()
    private val mainScheduler: Scheduler = get(MAIN_SCHEDULER)
    private val compositeDisposable = CompositeDisposable()
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private val adapter = SearchAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        compositeDisposable.clear()
    }

    private fun setupViews() {
        binding.searchRecyclerView.adapter = adapter

        viewModel.rentals.observe(viewLifecycleOwner,
            Observer { searchItems ->
                binding.emptySearchResults.visibility =
                    when {
                        searchItems.isEmpty() -> View.VISIBLE
                        else -> View.GONE
                    }
                binding.searchRecyclerView.visibility =
                    when {
                        searchItems.isEmpty() -> View.GONE
                        else -> {
                            View.VISIBLE
                        }
                    }
                adapter.update(searchItems)
            }
        )

        viewModel.showError.observe(viewLifecycleOwner,
            Observer { showError ->
                if (showError) {
                    Toast.makeText(
                        context,
                        "Unable to retrieve rentals at this time",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        )

        binding.searchEditText.textChanges()
            .skip(1)
            .map(CharSequence::toString)
            .filter(String::isEmpty)
            .subscribe { viewModel.clearList() }
            .also { compositeDisposable.add(it) }

        binding.searchEditText.textChanges()
            .debounce(DEBOUNCE_DURATION_MSEC, TimeUnit.MILLISECONDS, mainScheduler)
            .map(CharSequence::toString)
            .filter(String::isNotEmpty)
            .distinctUntilChanged()
            .subscribe(viewModel::fetchRentals)
            .also { compositeDisposable.add(it) }

        adapter.onItemClicked()
            .subscribe { (imageView, title) ->
                val extras = FragmentNavigatorExtras(
                    imageView to imageView.transitionName
                )
                val bundle = Bundle().apply {
                    putString("title", title)
                    putString("url", imageView.transitionName)
                }
                findNavController().navigate(R.id.profileFragment, bundle, null, extras)
            }
            .also { compositeDisposable.add(it) }
    }
}
