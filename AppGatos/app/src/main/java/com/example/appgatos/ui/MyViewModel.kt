package com.example.appgatos.ui

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appgatos.data.Repository
import com.example.appgatos.data.model.GatosItem
import com.example.appgatos.data.model.Rate
import com.example.appgatos.data.model.Weight
import com.example.appgatos.data.model.votadoItem
import com.example.appgatos.data.model.votos
import com.example.appgatos.ui.fragments.Votos
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel(val context: Context) : ViewModel() {


    private val repository = Repository(context)
    val liveData = MutableLiveData<List<GatosItem?>?>()
    val gatoSeleccionado = MutableLiveData<GatosItem?>()
    val infoLiveData = MutableLiveData<Weight?>()
    val votos = MutableLiveData<List<Rate>?>()
    val votoDado = MutableLiveData<votos?>()


    class MyViewModelFactory(private val context: Context): ViewModelProvider.Factory{

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(Context::class.java).newInstance(context)
        }
    }

    fun actualizar(){

        CoroutineScope(Dispatchers.IO).launch {
            val respuesta = repository.getBreeds()
            val code = respuesta.code()
            if(code == 200){
                val mirespuesta = respuesta.body()
                liveData.postValue(mirespuesta)
            }
        }

    }

    fun elegirGato(gato: GatosItem?){

        gatoSeleccionado.value = gato
    }

    fun votar(voto: Rate){

        CoroutineScope(Dispatchers.IO).launch {
            val respuesta = repository.votar(voto)

            if(respuesta.isSuccessful){
                val mirespuesta = respuesta.body()
                votoDado.postValue(mirespuesta)
            }
        }
    }

    fun votado(id_img: String){

        CoroutineScope(Dispatchers.IO).launch {
            val respuesta = repository.votado(id_img)

            if(respuesta.isSuccessful){
                val mirespuesta = respuesta.body()
                votos.postValue(mirespuesta)
            }
        }
    }
}