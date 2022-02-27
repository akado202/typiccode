package com.akado.typiccode.ui.interest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.akado.typiccode.databinding.FragmentRecentInterestBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecentInterestFragment: Fragment() {

    private val viewModel by viewModels<SaveInterestViewModel>()
    private var _binding: FragmentRecentInterestBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecentInterestBinding.inflate(inflater, container, false)
        binding.let {
            it.vm = viewModel
            it.lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}