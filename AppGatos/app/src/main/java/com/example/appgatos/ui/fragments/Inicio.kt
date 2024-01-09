package com.example.appgatos.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.example.appgatos.R
import com.example.appgatos.databinding.FragmentFourBinding
import com.example.appgatos.databinding.FragmentInicioBinding


class Inicio : Fragment() {

    private var _binding: FragmentInicioBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentInicioBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.button.setOnClickListener {

            Navigation.findNavController(it).navigate(R.id.action_inicio_to_FirstFragment)
        }
    }


}