package com.susanafigueroa.yournameroom.ui

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.susanafigueroa.yournameroom.YourNameRoomApplication
import com.susanafigueroa.yournameroom.ui.home.YourNameRoomViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            YourNameRoomViewModel(
                yourNameRoomApplication().container.usersRepository
            )
        }
    }
}

fun CreationExtras.yourNameRoomApplication(): YourNameRoomApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as YourNameRoomApplication)
