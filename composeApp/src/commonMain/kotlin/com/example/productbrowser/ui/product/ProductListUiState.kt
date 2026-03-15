package com.example.productbrowser.ui.product

import com.example.productbrowser.domain.model.Product

data class ProductListUiState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String? = null
)