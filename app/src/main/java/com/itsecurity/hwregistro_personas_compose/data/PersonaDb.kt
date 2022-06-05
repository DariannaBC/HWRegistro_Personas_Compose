package com.call.registropersonacompose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.call.registropersonacompose.model.Ocupacion
import com.call.registropersonacompose.model.Persona

@Database(
    entities = [
        Ocupacion::class,
        Persona::class
    ],
    exportSchema = false,
    version = 1
)
abstract class PersonaDb : RoomDatabase(){
    abstract val ocupacionDao: OcupacionDao
    abstract val personaDao: PersonaDao
}