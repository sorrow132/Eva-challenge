package com.yuresko.evachallenge.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class ModelMovie(
    @PrimaryKey
    val id: String,
    val name: String?,
    val year: String?,
    val poster: String?
) : Parcelable