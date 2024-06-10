package com.hello.venderadminapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.hello.venderadminapp.api.ProductDataClassItem
import com.hello.venderadminapp.viewmodel.AllUsersViewModel

@Composable
fun AllProducts(allUsersViewModel: AllUsersViewModel, navHostController: NavHostController) {
    val products = allUsersViewModel.getAllProducts()
    if (products.isNotEmpty()) {
        Spacer(modifier = Modifier.size(20.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            item {
                Text(
                    text = "All Products",
                    fontSize = 32.sp,
                    modifier = Modifier.padding(16.dp)
                )
            }
            items(products) {
                SingleProduct(productDataClassItem = it)
            }
        }
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
        }
    }
}


@Composable
fun SingleProduct(productDataClassItem: ProductDataClassItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp)),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {

        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart, // Replace with your user icon
                contentDescription = "User Icon",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(42.dp)// Adjusting the icon size
            )
            Spacer(modifier = Modifier.width(16.dp))
            Row {

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = productDataClassItem.name, // Replace with your user's name
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Rs. ${productDataClassItem.price}", // Replace with your user's status
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.secondary // Using the secondary color for the status
                    )
                }

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Qty. ${productDataClassItem.stock}", // Replace with your user's name
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = productDataClassItem.category, // Replace with your user's status
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.secondary // Using the secondary color for the status
                    )
                }
            }
        }
    }
}
