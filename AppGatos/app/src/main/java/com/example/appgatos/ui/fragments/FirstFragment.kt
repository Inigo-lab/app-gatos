package com.example.appgatos.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appgatos.R
import com.example.appgatos.databinding.FragmentFirstBinding
import com.example.appgatos.ui.MyAdapter
import com.example.appgatos.ui.MyViewModel


class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding!!
    private lateinit var listAdapter: MyAdapter

    private val gatoModel by activityViewModels<MyViewModel>() {
        MyViewModel.MyViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu, menu)

                val menuItem = menu.findItem(R.id.app_bar_search)
                val searchView = menuItem.actionView as SearchView
                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                    override fun onQueryTextSubmit(query: String?): Boolean {

                        listAdapter.filter.filter(query)
                        return true
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {

                        listAdapter.filter.filter(newText)
                        return true
                    }


                })

            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {

                return false
            }


        }, viewLifecycleOwner, androidx.lifecycle.Lifecycle.State.RESUMED)



        listAdapter = MyAdapter(gatoModel)
        val llm = LinearLayoutManager(requireContext())
        binding.recycler.layoutManager = llm
        binding.recycler.adapter = listAdapter

        binding.swipe.setOnRefreshListener {

            gatoModel.actualizar()
        }

        gatoModel.liveData.observe(viewLifecycleOwner){

            binding.swipe.isRefreshing = false
            if(it!=null){
                listAdapter.update(it)
            }


        }
        gatoModel.actualizar()
        binding.fab2.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_votos)
        }
    }


}