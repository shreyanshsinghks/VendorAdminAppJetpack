package com.hello.venderadminapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.hello.venderadminapp.navigation.Routes
import com.hello.venderadminapp.screens.allUsers.AllUsersViewModel

@Composable
fun DetailsScreen(
    user: Routes.DetailsScreen,
    allUsersViewModel: AllUsersViewModel,
    navHostController: NavHostController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = user.name,
                    style = MaterialTheme.typography.headlineLarge
                )
                Text(
                    text = "Email: ${user.email}",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Phone: ${user.phone}",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Address: ${user.Address}",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "PinCode: ${user.PinCode}",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Block: ${user.Block}",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Level: ${user.Level}",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Date of Account Creation: ${user.DateOfAccountCreation}",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "User ID: ${user.user_id}",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly){
            Button(onClick = {}, shape = RoundedCornerShape(12.dp)) {
                Text(text = "Block")
            }
            Button(onClick = {}, shape = RoundedCornerShape(12.dp)) {
                Text(text = "Approve")
            }
        }
    }
}