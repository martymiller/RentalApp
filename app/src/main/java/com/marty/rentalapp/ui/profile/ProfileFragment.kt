package com.marty.rentalapp.ui.profile

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.marty.rentalapp.databinding.FragmentProfileBinding
import com.marty.rentalapp.util.load
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        arguments?.let { bundle ->
            bundle.getString("url")?.let { url ->
                binding.profileImage.transitionName = url
                binding.profileImage.load(url)
            }
            bundle.getString("title")?.let { title ->
                binding.profileTitle.transitionName = title
                binding.profileTitle.text = title
            }
        }
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
