package com.company.chatwiseassignment.data.model

import com.google.gson.annotations.SerializedName

data class ProductList(
    @SerializedName("products")
    val products: ArrayList<Product>
)
