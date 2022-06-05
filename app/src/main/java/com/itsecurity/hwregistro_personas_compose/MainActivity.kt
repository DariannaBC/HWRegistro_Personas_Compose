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
import com.call.registropersonacompose.ui.theme.componentes.ListaOcupacionScreen
import com.call.registropersonacompose.ui.theme.componentes.ListadoPersonasScreen
import com.call.registropersonacompose.ui.theme.componentes.RegistroPersonasScreen
import com.call.registropersonacompose.ui.theme.componentes.registrosOcupacionScreen

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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    RegistroPersonaComposeTheme {
        MyApp()
    }
}