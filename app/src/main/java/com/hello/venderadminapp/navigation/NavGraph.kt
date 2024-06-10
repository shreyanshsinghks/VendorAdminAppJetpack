package com.hello.venderadminapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.hello.venderadminapp.screens.AddProduct
import com.hello.venderadminapp.screens.AllProducts
import com.hello.venderadminapp.screens.DetailsScreen
import com.hello.venderadminapp.screens.allUsers.AllUsers
import com.hello.venderadminapp.viewmodel.AllUsersViewModel


@Composable
fun NavGraph(allUsersViewModel: AllUsersViewModel, navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Routes.AllUsers) {
        composable<Routes.AllUsers> {
            AllUsers(allUsersViewModel, navHostController)
        }

        composable<Routes.DetailsScreen> {
            val data: Routes.DetailsScreen = it.toRoute()
            DetailsScreen(
                user = data,
                allUsersViewModel = allUsersViewModel,
                navHostController = navHostController
            )
        }

        composable<Routes.AddProduct> {
            AddProduct(allUsersViewModel = allUsersViewModel, navHostController = navHostController)
        }

        composable<Routes.AllProducts> {
            AllProducts(allUsersViewModel = allUsersViewModel, navHostController = navHostController)
        }
    }
}