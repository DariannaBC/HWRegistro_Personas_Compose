package com.call.registropersonacompose.di

import android.content.Context
import androidx.room.Room
import com.call.registropersonacompose.data.OcupacionDao
import com.call.registropersonacompose.data.PersonaDao
import com.call.registropersonacompose.data.PersonaDb
import com.call.registropersonacompose.data.Repository.OcupacionRepository
import com.call.registropersonacompose.data.Repository.PersonaRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesPrestamosDb(@ApplicationContext context: Context):PersonaDb{
        return  Room.databaseBuilder(
            context,
            PersonaDb::class.java,
            "PersonaDb")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun providesOcupacionDao(personaDb:PersonaDb): OcupacionDao {
        return personaDb.ocupacionDao
    }

    @Provides
    fun providesPersonaDao(personaDb: PersonaDb): PersonaDao {
        return  personaDb.personaDao
    }

    @Provides
    fun providesOcupacionRepository(ocupacionDao: OcupacionDao): OcupacionRepository {
        return  OcupacionRepository(ocupacionDao)
    }

    @Provides
    fun providesPersonaRepository(personaDao: PersonaDao): PersonaRepository {
        return  PersonaRepository(personaDao)
    }
}