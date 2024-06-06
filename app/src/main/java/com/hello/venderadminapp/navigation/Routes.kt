package com.hello.venderadminapp.navigation

import kotlinx.serialization.Serializable

sealed class Routes {
    @Serializable
    object AllUsers

    @Serializable
    data class DetailsScreen(
        val Address: String,
        val Block: Int,
        val DateOfAccountCreation: String,
        val Level: Int,
        val PinCode: String,
        val approved: Int,
        val email: String,
        val id: Int,
        val name: String,
        val password: String,
        val phone: String,
        val user_id: String
    )
}