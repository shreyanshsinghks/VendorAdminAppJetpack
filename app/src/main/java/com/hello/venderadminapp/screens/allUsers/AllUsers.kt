package com.hello.venderadminapp.screens.allUsers

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.hello.venderadminapp.navigation.Routes
import com.hello.venderadminapp.viewmodel.AllUsersViewModel
import com.hello.venderadminapp.viewmodel.State

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
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator()
                Text(text = "Loading...")
            }

        }

        State.SUCCESS.name -> {
            val response = allUsersViewModel.res.value
            Scaffold(
                topBar = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(64.dp)
                            .background(Color.LightGray, shape = RoundedCornerShape(12.dp))
                            .clip(RoundedCornerShape(12.dp)),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(imageVector = Icons.Rounded.Add,
                            contentDescription = null,
                            modifier = Modifier.clickable {
                                navHostController.navigate(Routes.AddProduct)
                            }
                        )
                        Icon(imageVector = Icons.Default.List, contentDescription = "All Products",
                            modifier = Modifier.clickable{
                                navHostController.navigate(Routes.AllProducts)
                            }
                            )
                    }
                }
            ) { padding ->
                padding
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 72.dp)
                ) {
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
}