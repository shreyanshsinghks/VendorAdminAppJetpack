package com.hello.venderadminapp.api

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST

interface API_Builder {
    @GET("/getAllUsers")
    suspend fun getAllUsers(): ArrayList<UserDataClassItem?>

    @GET("/getAllProducts")
    suspend fun getAllProducts(): ArrayList<ProductDataClassItem>

    @FormUrlEncoded
    @PATCH("/updateUserAccess")
    suspend fun updateUserAccess(
        @Field("userId") userId: String,
        @Field("approved") approved: Int,
        @Field("blocked") blocked: Int,
    ): Response<UserUpdateResponse>

    @FormUrlEncoded
    @POST("/createProduct")
    suspend fun createProduct(
        @Field("name") name: String,
        @Field("price") price: String,
        @Field("category") category: String,
        @Field("stock") stock: Int,
    ): Response<UserUpdateResponse>



}