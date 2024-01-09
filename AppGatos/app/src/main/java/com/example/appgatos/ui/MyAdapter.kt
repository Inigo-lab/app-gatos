package com.example.appgatos.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.appgatos.R
import com.example.appgatos.data.model.GatosItem
import com.example.appgatos.databinding.VistaCeldaBinding

class MyAdapter(val viewModel: MyViewModel) :
    RecyclerView.Adapter<MyAdapter.VistaCelda>(), Filterable {

    private var itemList = ArrayList<GatosItem?>()
    private var listaCopia = ArrayList<GatosItem?>()

    inner class VistaCelda(val binding: VistaCeldaBinding):
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VistaCelda {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = VistaCeldaBinding.inflate(layoutInflater,parent,false)
        return VistaCelda(binding)
    }

    override fun getItemCount(): Int {

        return itemList.size
    }

    override fun onBindViewHolder(holder: VistaCelda, position: Int) {

        val gato = itemList[position]

        holder.binding.textView.text = gato?.name

        holder.binding.textView2.text = gato?.origin

        holder.itemView.setOnClickListener {

            viewModel.elegirGato(gato)

            Navigation.findNavController(it).navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

    }

    fun update(newList: List<GatosItem?>){
        itemList.clear()
        itemList.addAll(newList)
        listaCopia.clear()
        listaCopia.addAll(newList)
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val busqueda = constraint.toString()

                if(busqueda.isEmpty()){
                    itemList = listaCopia

                }else{
                    itemList = listaCopia.filter {
                        it?.name?.lowercase()?.contains(busqueda.lowercase()) ?: false ||
                                it?.origin?.lowercase()?.contains(busqueda.lowercase()) ?: false ||
                                it?.temperament?.lowercase()?.contains(busqueda.lowercase()) ?: false
                    } as ArrayList<GatosItem?>
                }
                val filterResult = FilterResults()
                filterResult.values = itemList
                return filterResult
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                itemList = results?.values as ArrayList<GatosItem?>
                notifyDataSetChanged()
            }

        }
    }



}