package com.example.parcial20.Precentacion

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.parcial20.repositorio.MockRepositorio
import com.example.parcial20.repositorio.Repositorio
import kotlinx.coroutines.launch

class ClimaViewModel(repositorio: Repositorio) : ViewModel() {
    val Repositorio = MockRepositorio()// TODO recibirlo como parametro
    var estado by mutableStateOf<ClimaEstado>(ClimaEstado.Vacio)

    fun ejecutar(intencion: ClimaIntencion) {
        when(intencion){
            ClimaIntencion.actualiza -> actualizar()
        }
    }

    private  fun CargarClima(){
        estado = ClimaEstado.Cargando
        viewModelScope.launch{
            val clima = Repositorio.getClima()
            estado = ClimaEstado.Exitoso(clima)
        }

    }

    private fun actualizar( ) {
        estado = ClimaEstado.Cargando
        //TODO conseguir los datos desde un repositorio...
        viewModelScope.launch {

        }
        estado = ClimaEstado.Error("No funciono el servidor, esta todo roto")
    }
}
class ClimaViewModelFactory(
    private val repositorio: Repositorio
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass : Class<T>): T{
        if(modelClass.isAssignableFrom(ClimaViewModel::class.java)){
            return ClimaViewModel(repositorio) as T
        }
        throw IllegalArgumentException("Unknow viweModel Class")
    }
}