package com.susanafigueroa.yournameroom.data

import kotlinx.coroutines.flow.Flow

class UserDaoImplement(private val userDao: UserDao) : UserDao {
    override suspend fun insert(user: User) {
        userDao.insert(user)
    }

    override suspend fun update(user: User) {
        userDao.update(user)
    }

    override fun getUser(id: Int): Flow<User> {
        return userDao.getUser(id)
    }
}