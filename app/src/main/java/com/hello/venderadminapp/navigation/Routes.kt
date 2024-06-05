package com.hello.venderadminapp.navigation

import kotlinx.serialization.Serializable

sealed class Routes {
    @Serializable
    object AllUsers

}