package com.example.parcial20.repositorio

interface Repositorio {
    suspend fun getClima(): String
}