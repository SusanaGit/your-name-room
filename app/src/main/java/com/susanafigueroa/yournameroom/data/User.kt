package com.susanafigueroa.yournameroom.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User (
    @PrimaryKey
    val id: Int = 1,
    val name: String
)