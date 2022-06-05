package com.call.registropersonacompose.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.call.registropersonacompose.data.Repository.PersonaRepository
import com.call.registropersonacompose.model.Ocupacion
import com.call.registropersonacompose.model.Persona
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonaViewModel @Inject constructor(
    val personaRepository: PersonaRepository
): ViewModel(){
    var nombres by mutableStateOf("")
    var email by mutableStateOf("")
    var salario by mutableStateOf("")

    var personas = personaRepository.getList()
        private set

    fun Guardar(){
        viewModelScope.launch {
            personaRepository.insertar(
                Persona(
                    nombres = nombres,
                    email = email,
                    salario = salario.toFloat()
                )
            )
        }
    }
}
