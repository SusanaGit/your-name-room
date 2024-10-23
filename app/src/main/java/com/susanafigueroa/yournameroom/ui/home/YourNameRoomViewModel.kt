package com.susanafigueroa.yournameroom.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.susanafigueroa.yournameroom.data.User
import com.susanafigueroa.yournameroom.data.Users
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class YourNameRoomViewModel(
    private val users: Users
): ViewModel() {

    private val _userName = MutableStateFlow("")
    val userName: StateFlow<String> = _userName.asStateFlow()

    init {
        getUserName()
    }

    private fun getUserName() {
        viewModelScope.launch {
            users.getUserStream(1).collect { user ->
                _userName.value = user?.name ?: ""
            }
        }
    }

    fun saveUser(newName: String) {
        viewModelScope.launch {
            val user = User(1, newName)
            users.insertUser(user)
            _userName.value = newName
        }
    }
}