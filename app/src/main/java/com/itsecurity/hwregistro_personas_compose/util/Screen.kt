package com.itsecurity.hwregistro_personas_compose.util

 sealed class Screen(val route: String) {
     object RegistroPersonaScreen: Screen("Registropersonas")
     object ListadoPersonaScreen: Screen("Listadopersonas")

     object RegistroOcupacionesScreen: Screen("RegistroOcupaciones")
     object ListadoOcupacionesScreen: Screen("ListadoOcupacionesScreen")

}