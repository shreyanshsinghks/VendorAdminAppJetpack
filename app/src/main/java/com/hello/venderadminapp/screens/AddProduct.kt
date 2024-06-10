package com.hello.venderadminapp.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.hello.venderadminapp.navigation.Routes
import com.hello.venderadminapp.viewmodel.AllUsersViewModel

@Composable
fun AddProduct(allUsersViewModel: AllUsersViewModel, navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val name = remember { mutableStateOf("") }
        val price = remember { mutableStateOf("") }
        val category = remember { mutableStateOf("") }
        val stock = remember { mutableStateOf("") }
        val context = LocalContext.current

        Text(
            text = "Enter the product details:",
            fontSize = 32.sp
        )

        Spacer(modifier = Modifier.size(25.dp))

        OutlinedTextField(
            value = name.value,
            onValueChange = {
                name.value = it
            },
            placeholder = {
                Text(text = "Enter Product Name")
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Name")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Face,
                    contentDescription = "Face Icon"
                )
            }
        )

        Spacer(modifier = Modifier.size(20.dp))

        OutlinedTextField(
            value = price.value,
            onValueChange = {
                price.value = it
            },
            placeholder = {
                Text(text = "Product Price")
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Product Price")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Info,
                    contentDescription = null
                )
            })

        Spacer(modifier = Modifier.size(20.dp))

        OutlinedTextField(
            value = category.value,
            onValueChange = {
                category.value = it
            },
            placeholder = {
                Text(text = "Category")
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Category")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = null
                )
            })
        Spacer(modifier = Modifier.size(20.dp))

        OutlinedTextField(value = stock.value, onValueChange = {
            stock.value = it
        }, placeholder = {
            Text(text = "Enter Quantity Available")
        }, modifier = Modifier.fillMaxWidth(), label = {
            Text(text = "Quality Available")
        }, leadingIcon = {
            Icon(
                imageVector = Icons.Filled.CheckCircle,
                contentDescription = "Face Icon"
            )
        })

        Spacer(modifier = Modifier.size(20.dp))

        Button(
            onClick = {
                      allUsersViewModel.addProduct(
                          name = name.value,
                          price = price.value,
                          category = category.value,
                          stock = stock.value.toInt()
                      )
                Toast.makeText(context, "Product Added!", Toast.LENGTH_SHORT).show()
                navHostController.navigate(Routes.AllUsers)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Add Product")
        }
    }
}