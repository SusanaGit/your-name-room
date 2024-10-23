package com.susanafigueroa.yournameroom.data

import androidx.room.Entity

@Entity(tableName = "user")
data class User (
    val name: String
)