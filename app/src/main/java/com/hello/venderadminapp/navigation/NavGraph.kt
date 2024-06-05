package com.hello.venderadminapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hello.venderadminapp.screens.allUsers.AllUsers
import com.hello.venderadminapp.screens.allUsers.AllUsersViewModel


@Composable
fun NavGraph(allUsersViewModel: AllUsersViewModel, navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Routes.AllUsers){
        composable<Routes.AllUsers> {
            AllUsers(allUsersViewModel, navHostController)
        }
    }

}