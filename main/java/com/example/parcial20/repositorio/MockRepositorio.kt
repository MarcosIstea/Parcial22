package com.example.parcial20.repositorio

class MockRepositorio : Repositorio {
    override suspend fun getClima(): String {
        return "Va a Llover"
    }
}