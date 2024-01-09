package com.example.appgatos.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appgatos.R
import com.example.appgatos.data.model.GatosItem
import com.example.appgatos.data.model.Rate
import com.example.appgatos.databinding.FavoritosBinding
import com.example.appgatos.databinding.VistaCeldaBinding

class VotosAdapter() : RecyclerView.Adapter<VotosAdapter.VistaCelda>(){

    private var votos = ArrayList<Rate>()

    inner class VistaCelda(val binding: FavoritosBinding):
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VistaCelda {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = FavoritosBinding.inflate(layoutInflater,parent,false)
        return VistaCelda(binding)
    }

    override fun getItemCount(): Int {
        return votos.size
    }

    override fun onBindViewHolder(holder: VistaCelda, position: Int) {

        val voti : Rate = votos[position]

        with(holder.binding){
            Glide.with(holder.itemView.context)
                .load("https://cdn2.thecatapi.com/images/${voti.imageId}.jpg")
                .into(holder.binding.imageView)
        }
    }

    fun update(lista: List<Rate>){
        votos.clear()
        votos.addAll(lista)
        notifyDataSetChanged()
    }
}