package com.susanafigueroa.yournameroom.data

import android.content.Context

interface AppContainer {
    val usersRepository: Users
}

class AppDataContainer(private val context: Context): AppContainer {
    override val usersRepository: Users by lazy {
        OfflineUsers(
            AppDatabase.getDatabase(context).userDao()
        )
    }
}