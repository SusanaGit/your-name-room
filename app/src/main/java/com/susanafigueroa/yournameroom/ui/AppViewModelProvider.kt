package com.susanafigueroa.yournameroom.ui

import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.susanafigueroa.yournameroom.YourNameRoomApplication
import com.susanafigueroa.yournameroom.ui.home.YourNameRoomViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            YourNameRoomViewModel(
                YourNameRoomApplication().container.usersRepository
            )
        }
    }
}