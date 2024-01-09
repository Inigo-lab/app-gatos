package com.example.appgatos.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.appgatos.R
import com.example.appgatos.databinding.FragmentVotosBinding
import com.example.appgatos.ui.MyViewModel
import com.example.appgatos.ui.VotosAdapter


class Votos : Fragment() {

    private lateinit var binding: FragmentVotosBinding

    private val gatoModel by activityViewModels<MyViewModel>() {
        MyViewModel.MyViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVotosBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recycler.layoutManager = LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,true)

        val votos = VotosAdapter()

        binding.recycler.adapter = votos

        gatoModel.votos.observe(viewLifecycleOwner){
            if(it!=null)
                votos.update(it)
        }
        gatoModel.votado("wwaaaww")
    }
}
