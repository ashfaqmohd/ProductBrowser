package com.example.productbrowser.domain.usecase.product

import com.example.productbrowser.data.remote.NetworkResult
import com.example.productbrowser.domain.model.Product
import com.example.productbrowser.domain.repository.ProductRepository

class GetProductsUseCase(
    private val repository: ProductRepository
) {

    suspend operator fun invoke(): NetworkResult<List<Product>> {
        return repository.getProducts()
    }
}