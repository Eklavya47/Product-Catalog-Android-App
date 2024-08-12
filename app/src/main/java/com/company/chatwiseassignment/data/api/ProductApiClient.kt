package com.company.chatwiseassignment.data.api

import com.company.chatwiseassignment.data.model.ProductList
import retrofit2.Response
import retrofit2.http.GET

interface ProductApiClient {
    @GET("products")
    suspend fun getProducts(): Response<ProductList>
}