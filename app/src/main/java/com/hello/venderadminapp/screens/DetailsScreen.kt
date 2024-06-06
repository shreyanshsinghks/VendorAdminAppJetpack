package com.hello.venderadminapp.screens

import android.widget.Toast
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
    var status = remember {
        mutableIntStateOf(user.approved)
    }
    val context = LocalContext.current
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
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = {
                allUsersViewModel.updateUserAccess(userId = user.user_id, approved = 0, blocked = 1)
                Toast.makeText(context, "User Blocked", Toast.LENGTH_SHORT).show()
            }, shape = RoundedCornerShape(12.dp)) {
                Text(text = "Block")
            }
            Button(onClick = {
                allUsersViewModel.updateUserAccess(userId = user.user_id, approved = 1, blocked = 0)
                Toast.makeText(context, "User Approved", Toast.LENGTH_SHORT).show()
                status.intValue = 1
            }, shape = RoundedCornerShape(12.dp)) {
                when (status.intValue){
                    1 -> Text(text = "Approved")
                    0 -> Text(text = "Click To Approve")
                }
            }
        }
    }
}