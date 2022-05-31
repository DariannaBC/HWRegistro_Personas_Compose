package com.itsecurity.hwregistro_personas_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.itsecurity.hwregistro_personas_compose.ui.theme.HWRegistro_Personas_ComposeTheme

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

