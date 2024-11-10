package com.example.parcial20.repositorio

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import io.ktor.http.buildUrl
//import kotlinx.serialization.kotlinx.json.json
//import kotlinx.serialization.json.json

class NetworkRepositorio : Repositorio {

    private val cliente = HttpClient(){
install(ContentNegotiation){
//    json(Json{ignoreU})
}//minuto 49:12
    }

    override suspend fun getClima(): String {
    val respuesta= cliente.get("https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={609c9e4d2af7f1a2c5c346c884714240}")

        if (respuesta.status== HttpStatusCode.OK) { return "1213"
        }else{
            throw Exception()
        }


    }


}
