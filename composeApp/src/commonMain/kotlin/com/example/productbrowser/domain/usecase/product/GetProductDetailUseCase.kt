package com.example.productbrowser.domain.usecase.product

import com.example.productbrowser.data.remote.NetworkResult
import com.example.productbrowser.domain.model.Product
import com.example.productbrowser.domain.repository.ProductRepository

class GetProductDetailUseCase(
    private val repository: ProductRepository
) {

    suspend operator fun invoke(id: Int): NetworkResult<Product> {
        return repository.getProductDetail(id)
    }
}