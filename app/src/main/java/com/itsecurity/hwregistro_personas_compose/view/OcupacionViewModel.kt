package com.call.registropersonacompose.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.call.registropersonacompose.data.Repository.OcupacionRepository
import com.call.registropersonacompose.model.Ocupacion
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OcupacionViewModel @Inject constructor(
    val ocupacionRepository: OcupacionRepository
): ViewModel() {

    var nombre by mutableStateOf("")

    var ocupaciones = ocupacionRepository.getList()
    private set

    fun Guardar(){
        viewModelScope.launch {
            ocupacionRepository.insertar(
                Ocupacion(
                    nombres = nombre
                )
            )
        }
    }
}