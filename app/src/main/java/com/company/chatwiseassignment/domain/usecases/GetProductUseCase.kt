package com.company.chatwiseassignment.domain.usecases

import com.company.chatwiseassignment.data.model.Product
import com.company.chatwiseassignment.domain.repository.ProductRepository
import javax.inject.Inject

class GetProductUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    suspend fun invoke(): ArrayList<Product> = productRepository.getProducts()
}