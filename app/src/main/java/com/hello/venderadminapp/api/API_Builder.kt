package com.hello.venderadminapp.api

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.PATCH

interface API_Builder {
    @GET("/getAllUsers")
    suspend fun getAllUsers(): ArrayList<UserDataClassItem?>

    @FormUrlEncoded
    @PATCH("/updateUserAccess")
    suspend fun updateUserAccess(
        @Field("userId") userId: String,
        @Field("approved") approved: Int,
        @Field("blocked") blocked: Int,
    ): Response<UserUpdateResponse>



}