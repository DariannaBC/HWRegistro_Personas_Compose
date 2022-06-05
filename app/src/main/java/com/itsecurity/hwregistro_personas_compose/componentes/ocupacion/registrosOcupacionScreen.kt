package com.call.registropersonacompose.ui.theme.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.call.registropersonacompose.view.OcupacionViewModel

@Composable
fun registrosOcupacionScreen(backToListadoOcupaciones:() -> Unit, viewModel: OcupacionViewModel = hiltViewModel()
){

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registro de Ocupaciones") })
        }
    ) {it
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)) {

            OutlinedTextField(
                value = viewModel.nombre,
                onValueChange = {viewModel.nombre = it},
                label = { Text(text = "Ocupacion") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(onClick = {
                viewModel.Guardar()
                backToListadoOcupaciones()
            },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
            ) {
                Text(text = "Guardar")
            }
        }
    }
}