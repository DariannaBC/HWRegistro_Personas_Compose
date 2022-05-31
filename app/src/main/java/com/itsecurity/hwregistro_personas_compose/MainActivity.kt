package com.itsecurity.hwregistro_personas_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.itsecurity.hwregistro_personas_compose.ui.theme.RegistroPersonaComposeTheme
import com.itsecurity.hwregistro_personas_compose.util.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp(){
    RegistroPersonaComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val navHostController = rememberNavController()
            NavHost(navController = navHostController,
                startDestination = Screen.ListadoPersonaScreen.route){

                composable(route = Screen.ListadoPersonaScreen.route){
                    ListadoPersonasScreen(goRegistroPersonas = {navHostController.navigate(Screen.RegistroPersonaScreen.route)},
                        goListaOcupaciones = {navHostController.navigate(Screen.ListadoOcupacionesScreen.route)})
                }

                composable(route = Screen.RegistroPersonaScreen.route){
                    RegistroPersonasScreen(backToListadoPersonas ={ navHostController.navigate(Screen.ListadoPersonaScreen.route)})
                }

                composable(route = Screen.ListadoOcupacionesScreen.route){
                    ListaOcupacionScreen(goToRegistroOcupaciones = {navHostController.navigate(Screen.RegistroOcupacionesScreen.route)})
                }

                composable(route = Screen.RegistroOcupacionesScreen.route){
                    registrosOcupacionScreen(backToListadoOcupaciones = {navHostController.navigate(Screen.ListadoOcupacionesScreen.route)})
                }
            }
        }
    }
}

@Composable
fun ListadoPersonasScreen(goRegistroPersonas:() -> Unit, goListaOcupaciones:() -> Unit){

    val ScaffoldState = rememberScaffoldState()

    Scaffold(
        topBar ={
            TopAppBar(title = { Text(text = "Listado de Personas")})
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    goRegistroPersonas()
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Nuevo")
            }
        },
        scaffoldState = ScaffoldState

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Button(onClick = {
                goListaOcupaciones()
            }) {
                Text(text = "Ocupaciones")
            }

            val listaPersonas = listOf("1", "Darianna", "dari@gmail.com", "500.00")
            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ){
                items(listaPersonas) { persons ->
                    Row() {
                        Text(text = "$persons")
                    }
                }
            }
        }
    }
}

@Composable
fun RegistroPersonasScreen(backToListadoPersonas:() -> Unit){

    var nombres by rememberSaveable() {
        mutableStateOf("")
    }

    var email by rememberSaveable() {
        mutableStateOf("")
    }

    var salario by rememberSaveable() {
        mutableStateOf("")
    }

    val ScaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registro de Personas")})
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)) {

            OutlinedTextField(
                value = nombres,
                onValueChange = {nombres = it},
                label = { Text(text = "Nombres")},
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = email,
                onValueChange = {email = it},
                label = { Text(text = "Email")},
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = salario,
                onValueChange = {salario = it},
                label = { Text(text = "Salario")},
                modifier = Modifier.fillMaxWidth()
            )

            Button(onClick = {
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

@Composable
fun ListaOcupacionScreen(goToRegistroOcupaciones:() -> Unit){
    val ScaffoldState = rememberScaffoldState()

    Scaffold(
        topBar ={
            TopAppBar(title = { Text(text = "Listado de Ocupaciones")})
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    goToRegistroOcupaciones()
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Nuevo")
            }
        },
        scaffoldState = ScaffoldState

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {

            val listaOcupaciones = listOf("1", "Admin")
            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ){
                items(listaOcupaciones) { ocupaciones ->
                    Row() {
                        Text(text = "$ocupaciones")
                    }
                }
            }
        }
    }
}

@Composable
fun registrosOcupacionScreen(backToListadoOcupaciones:() -> Unit){
    var ocupacion by rememberSaveable() {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registro de Ocupaciones")})
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)) {

            OutlinedTextField(
                value = ocupacion,
                onValueChange = {ocupacion = it},
                label = { Text(text = "Ocupacion")},
                modifier = Modifier.fillMaxWidth()
            )

            Button(onClick = {
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    RegistroPersonaComposeTheme {
        MyApp()
    }
}