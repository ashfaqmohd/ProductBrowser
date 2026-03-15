package com.example.productbrowser.domain.usecase.product

import com.example.productbrowser.domain.repository.ProductRepository

class SearchProductsUseCase(
    private val repo: ProductRepository
) {
    suspend operator fun invoke(query: String) =
        repo.searchProducts(query)
}