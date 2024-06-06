package com.hello.venderadminapp.screens.allUsers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.hello.venderadminapp.navigation.Routes

@Composable
fun AllUsers(allUsersViewModel: AllUsersViewModel, navHostController: NavHostController) {
    when (allUsersViewModel.state.value) {
        State.DEFAULT.name -> {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(text = "Welcome to the Vender Admin App")
            }
        }

        State.LOADING.name -> {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator()
                Text(text = "Loading...")
            }

        }

        State.SUCCESS.name -> {
            val response = allUsersViewModel.res.value
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(response) {
                    SingleUserCard(user = it, onViewDetailsClick = {
                        if (it != null) {
                            navHostController.navigate(
                                Routes.DetailsScreen(
                                    Address = it.Address,
                                    Block = it.Block,
                                    DateOfAccountCreation = it.DateOfAccountCreation,
                                    Level = it.Level,
                                    PinCode = it.PinCode,
                                    approved = it.approved,
                                    email = it.email,
                                    id = it.id,
                                    name = it.name,
                                    password = it.password,
                                    phone = it.phone,
                                    user_id = it.user_id
                                )
                            )
                        }
                    })
                }
            }
        }
    }
}