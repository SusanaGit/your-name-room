package com.susanafigueroa.yournameroom.data

import kotlinx.coroutines.flow.Flow

interface Users {

    fun getUserStream(id: Int): Flow<User?>

    suspend fun insertUser(user: User)

    suspend fun updateUser(user: User)

}