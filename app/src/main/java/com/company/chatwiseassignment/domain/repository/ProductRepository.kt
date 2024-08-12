package com.company.chatwiseassignment.domain.repository

import com.company.chatwiseassignment.data.api.ProductApiClient
import com.company.chatwiseassignment.data.model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val productApiClient: ProductApiClient
) {
    suspend fun getProducts(): ArrayList<Product>{
        var productList = ArrayList<Product>()
        withContext(Dispatchers.IO){
            try {
                val response = productApiClient.getProducts()
                if(response.isSuccessful){
                    val body = response.body()
                    productList.addAll(body!!.products)
                }
            }
            catch (exception: Exception){}
        }
        return productList
    }
}