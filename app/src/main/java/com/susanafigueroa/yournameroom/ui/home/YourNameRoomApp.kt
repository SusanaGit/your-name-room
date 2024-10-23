package com.susanafigueroa.yournameroom

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.susanafigueroa.yournameroom.ui.AppViewModelProvider
import com.susanafigueroa.yournameroom.ui.home.YourNameRoomViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun YourNameRoomApp(
    viewModel: YourNameRoomViewModel = viewModel( factory = AppViewModelProvider.Factory )
) {

    val currentUserName by viewModel.userName.collectAsState()

    var newName by remember { mutableStateOf(currentUserName) }

    LaunchedEffect(key1 = currentUserName) {
        if(currentUserName.isNotEmpty()) {
            newName = currentUserName
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.your_name_room_app)
                    )
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = Color(0xFFF1E27A)
                )
            )
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TextField(
                value = newName,
                onValueChange = { newNameValue ->
                    newName = newNameValue
                },
                label = {
                    Text(stringResource(R.string.enter_your_name))
                }
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    newName?.let {
                        viewModel.saveUser(it)
                    }
                }
            ) {
                Text(stringResource(R.string.save))
            }
        }
    }
}

