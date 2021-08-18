package com.yuresko.evachallenge.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yuresko.evachallenge.models.ModelMovie
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoRepo {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(modelMovie: ModelMovie)

    @Query("SELECT * FROM ModelMovie WHERE id == id")
    fun getAllWatched(): Flow<ModelMovie>

}