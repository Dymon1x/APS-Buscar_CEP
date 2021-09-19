package com.leonardo.aps.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.leonardo.aps.HomeViewModel
import com.leonardo.aps.R
import com.leonardo.aps.adapter.AdapterCEP
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

        if (searchText != null) {
            Log.i("CEEEEEEEEEEEEEEEEEEP", searchText)
        }

        fragmentDetailsBinding.rvCep.layoutManager =
            LinearLayoutManager(
                view.context,
                RecyclerView.VERTICAL,
                false
            )

        viewModel.homeView.observe(viewLifecycleOwner, {
            fragmentDetailsBinding.rvCep.adapter = searchText?.let { it1 -> AdapterCEP(it1, this) }
        })


/*        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().navigate(R.id.action_fragmentDetails_to_fragmentHome)
        }

        callback.isEnabled*/

    }

    companion object {
        fun newInstance() = FragmentDetails()
    }


}