package com.example.appgatos.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.appgatos.R
import com.example.appgatos.databinding.FragmentFourBinding
import com.example.appgatos.databinding.FragmentThBinding
import com.example.appgatos.ui.MyViewModel

class FourFragment : Fragment() {

    private val gatoModel by activityViewModels<MyViewModel>()
    private var _binding: FragmentFourBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFourBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        gatoModel.gatoSeleccionado.observe(viewLifecycleOwner){


        }
    }

}