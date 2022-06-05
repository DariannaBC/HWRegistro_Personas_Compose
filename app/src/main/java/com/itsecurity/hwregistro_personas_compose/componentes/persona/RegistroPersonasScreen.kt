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
import com.call.registropersonacompose.view.PersonaViewModel

@Composable
fun RegistroPersonasScreen(backToListadoPersonas:() -> Unit, viewModel: PersonaViewModel = hiltViewModel()){

    val ScaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registro de Personas") })
        }){it
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)) {

            OutlinedTextField(
                value = viewModel.nombres,
                onValueChange = {viewModel.nombres = it},
                label = { Text(text = "Nombres") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = viewModel.email,
                onValueChange = {viewModel.email = it},
                label = { Text(text = "Email") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = viewModel.salario,
                onValueChange = {viewModel.salario = it},
                label = { Text(text = "Salario") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(onClick = {
                viewModel.Guardar()
                backToListadoPersonas()
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

