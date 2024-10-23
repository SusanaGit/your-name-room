package com.susanafigueroa.yournameroom

import android.app.Application
import com.susanafigueroa.yournameroom.data.AppContainer
import com.susanafigueroa.yournameroom.data.AppDataContainer

class YourNameRoomApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}