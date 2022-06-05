package com.call.registropersonacompose.data

import androidx.room.*
import com.call.registropersonacompose.model.Ocupacion
import kotlinx.coroutines.flow.Flow

@Dao
interface OcupacionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(ocupacion : Ocupacion)

    @Delete
    suspend fun eliminar(ocupacion : Ocupacion)

    @Query(
        """
        SELECT * 
        FROM Ocupaciones
        WHERE ocupacionId=:ocupacionId
    """
    )
    fun buscar(ocupacionId: Int): Flow<Ocupacion>

    @Query(
        """
        SELECT * 
        FROM Ocupaciones
        ORDER BY ocupacionId    
    """
    )
    fun getList(): Flow<List<Ocupacion>>
}