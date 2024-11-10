package com.example.parcial20.Precentacion

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.parcial20.repositorio.NetworkRepositorio


@Composable
fun ClimaPage(
    modifier:Modifier = Modifier
) {
    val viewModel : ClimaViewModel = viewModel<ClimaViewModel>(
        factory = ClimaViewModelFactory(
            repositorio =  NetworkRepositorio()
        )
    )

    ClimaView(
        modifier = Modifier,
        estado = viewModel.estado,
    ) {
        viewModel.ejecutar(it)
    }
}