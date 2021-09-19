package com.leonardo.aps.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.leonardo.aps.R
import com.leonardo.aps.databinding.FragmentHomeBinding

class FragmentHome : Fragment(R.layout.fragment_home) {

    private lateinit var fragmentHomeBinding: FragmentHomeBinding

    private lateinit var communicator: Communicator

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHomeBinding.bind(view)
        fragmentHomeBinding = binding

/*        communicator = requireActivity() as Communicator

        binding.btnSearch.setOnClickListener{
            communicator.passDataCom(fragmentHomeBinding.editSearch.text.toString())
        }*/

    }


    override fun onDestroyView() {
        fragmentHomeBinding
        super.onDestroyView()

    }
    companion object{
        fun newInstance() = FragmentHome()
    }
}