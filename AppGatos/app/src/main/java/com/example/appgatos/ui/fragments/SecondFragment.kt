package com.example.appgatos.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.appgatos.R
import com.example.appgatos.data.model.Rate
import com.example.appgatos.databinding.FragmentSecondBinding
import com.example.appgatos.ui.MainActivity
import com.example.appgatos.ui.MyViewModel
import com.example.appgatos.ui.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class SecondFragment : Fragment() {

    private val gatoModel by activityViewModels<MyViewModel>()
    private var _binding: FragmentSecondBinding? = null


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ViewPagerAdapter(requireActivity())
        binding.viewpager.adapter = adapter
        TabLayoutMediator(binding.tablayout, binding.viewpager){ tab, position ->
            tab.text = if(position==1) "Stats" else "Information"
        }.attach()

        gatoModel.gatoSeleccionado.observe(viewLifecycleOwner){

            Glide.with((requireContext())).load(it?.image?.url).placeholder(R.drawable.ic_launcher_foreground).into(binding.materialupProfileBackdrop)

            binding.toolbar.title = it?.name
            binding.toolbar.setTitleTextColor(resources.getColor(R.color.black))

            binding.fab.setOnClickListener {vot->

                val voto = it?.image?.id.let { vot->
                    Rate(
                        vot,
                        "wwaaaww",
                        1
                    )
                }
                if(voto!=null){
                    gatoModel.votar(voto)
                }

                Toast.makeText(requireContext(), "Añadido a favoritos", Toast.LENGTH_SHORT).show()
            }
        }



//        binding.buttonSecond.setOnClickListener {
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}