package com.marty.rentalapp.ui.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.jakewharton.rxbinding4.widget.textChanges
import com.marty.rentalapp.databinding.SearchFragmentBinding
import com.marty.rentalapp.di.MAIN_SCHEDULER
import io.reactivex.rxjava3.core.Scheduler
import org.koin.android.ext.android.get
import org.koin.core.KoinComponent
import java.util.concurrent.TimeUnit

class SearchFragment : Fragment(), KoinComponent {

    companion object {
        const val DEBOUNCE_DURATION_MSEC: Long = 300L
    }

    private val viewModel: SearchViewModel by activityViewModels()
    private val mainScheduler: Scheduler = get(MAIN_SCHEDULER)
    private var _binding: SearchFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SearchFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupViews() {
        binding.searchEditText.textChanges()
            .map(CharSequence::toString)
            .filter(String::isEmpty)
            .distinctUntilChanged()
            .subscribe { viewModel.clearList() }

        binding.searchEditText.textChanges()
                .debounce(DEBOUNCE_DURATION_MSEC, TimeUnit.MILLISECONDS, mainScheduler)
                .map(CharSequence::toString)
                .filter(String::isNotEmpty)
                .distinctUntilChanged()
                .subscribe(viewModel::fetchRentals)
    }
}
