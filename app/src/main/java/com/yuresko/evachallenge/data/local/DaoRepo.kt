package com.yuresko.evachallenge.data.local

import androidx.room.*
import com.yuresko.evachallenge.models.ModelMovie
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoRepo {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(modelMovie: ModelMovie)

    @Query("SELECT * FROM ModelMovie WHERE id == id")
    fun getWatchedMovie(): Flow<ModelMovie>

    @Delete
    fun deleteWatchedMovie(modelMovie: ModelMovie)
}