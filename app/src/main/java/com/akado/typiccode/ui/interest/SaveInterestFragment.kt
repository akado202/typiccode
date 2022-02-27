package com.akado.typiccode.ui.interest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.akado.typiccode.databinding.FragmentSaveInterestBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SaveInterestFragment : Fragment() {

    val viewModel by viewModels<SaveInterestViewModel>()
    private var _binding: FragmentSaveInterestBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSaveInterestBinding.inflate(inflater, container, false)
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