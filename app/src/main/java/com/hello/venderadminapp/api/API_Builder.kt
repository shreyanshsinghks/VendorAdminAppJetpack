package com.hello.venderadminapp.api

import retrofit2.http.GET

interface API_Builder {
    @GET("/getAllUsers")
    suspend fun getAllUsers(): ArrayList<UserDataClassItem?>

}