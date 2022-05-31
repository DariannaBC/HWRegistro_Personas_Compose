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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.itsecurity.hwregistro_personas_compose.ui.theme.HWRegistro_Personas_ComposeTheme
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
fun MyApp() {
    RegistroPersonaComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val navHostController = rememberNavController()
            NavHost(
                navController = navHostController,
                startDestination = Screen.ListadoPersonaScreen.route
            ) {

                composable(route = Screen.ListadoPersonaScreen.route) {
                    ListadoPersonasScreen(goRegistroPersonas = { navHostController.navigate(Screen.RegistroPersonaScreen.route) },
                        goListaOcupaciones = { navHostController.navigate(Screen.ListadoOcupacionesScreen.route) })
                }

                composable(route = Screen.RegistroPersonaScreen.route) {
                    RegistroPersonasScreen(backToListadoPersonas = {
                        navHostController.navigate(
                            Screen.ListadoPersonaScreen.route
                        )
                    })
                }

                composable(route = Screen.ListadoOcupacionesScreen.route) {
                    ListaOcupacionScreen(goToRegistroOcupaciones = {
                        navHostController.navigate(
                            Screen.RegistroOcupacionesScreen.route
                        )
                    })
                }

                composable(route = Screen.RegistroOcupacionesScreen.route) {
                    registrosOcupacionScreen(backToListadoOcupaciones = {
                        navHostController.navigate(
                            Screen.ListadoOcupacionesScreen.route
                        )
                    })
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
