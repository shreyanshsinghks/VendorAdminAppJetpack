package com.hello.venderadminapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.hello.venderadminapp.navigation.NavGraph
import com.hello.venderadminapp.viewmodel.AllUsersViewModel
import com.hello.venderadminapp.ui.theme.VenderAdminAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val allUsersViewModel: AllUsersViewModel by viewModels()
            val navHostController = rememberNavController()
            VenderAdminAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        NavGraph(
                            allUsersViewModel = allUsersViewModel,
                            navHostController = navHostController
                        )
                    }
                }
            }
        }
    }
}

