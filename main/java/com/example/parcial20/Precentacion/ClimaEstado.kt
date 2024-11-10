package com.example.parcial20.Precentacion



sealed class ClimaEstado {
    data object Vacio : ClimaEstado()
    data object Cargando: ClimaEstado()
    data class Exitoso(val clima: String) : ClimaEstado()//para tener parametro debe ser data class
    data class Error(val mensaje: String) : ClimaEstado()
}

public class Clima(
    val temperatura: Double,
    val sencacionTermica: Double,
    val humedad: Double,
    val estado: String,
    val velocidadDelviento: Double,
    val latitud: Double,
    val longitud: Double

)
