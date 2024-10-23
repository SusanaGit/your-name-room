package com.susanafigueroa.yournameroom.data

import kotlinx.coroutines.flow.Flow

class OfflineUsers(
    private val userDao: UserDao
): Users{
    override fun getUserStream(id: Int): Flow<User?> = userDao.getUser(id)

    override suspend fun insertUser(user: User) = userDao.insert(user)

    override suspend fun updateUser(user: User) = userDao.update(user)
}