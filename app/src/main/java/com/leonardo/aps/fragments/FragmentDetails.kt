package com.leonardo.aps.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.leonardo.aps.HomeViewModel
import com.leonardo.aps.R
import com.leonardo.aps.databinding.FragmentDetailsBinding
import com.leonardo.aps.webservices.serviceWEB

@Suppress("UNCHECKED_CAST", "CAST_NEVER_SUCCEEDS")
class FragmentDetails : Fragment(R.layout.fragment_details) {

    private lateinit var fragmentDetailsBinding: FragmentDetailsBinding

    private val viewModel by viewModels<HomeViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelCLass: Class<T>): T {
                return HomeViewModel(serviceWEB) as T
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentDetailsBinding.bind(view)
        fragmentDetailsBinding = binding

        val searchText = requireArguments().getString("search")

        searchText?.let { viewModel.getCEP(it) }

        viewModel.homeView.observe(viewLifecycleOwner, {

            binding.resCep.text = it.cep
            binding.resRua.text = it.street
            binding.resCidade.text = it.city
            binding.resEstado.text = it.state
            binding.resBairro.text = it.neighborhood
        })

    }

    companion object {
        fun newInstance() = FragmentDetails()
    }
}