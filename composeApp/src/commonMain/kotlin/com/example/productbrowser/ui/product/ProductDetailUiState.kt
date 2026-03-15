package com.example.productbrowser.ui.product

import com.example.productbrowser.domain.model.Product

data class ProductDetailUiState(
    val isLoading: Boolean = false,
    val product: Product? = null,
    val error: String? = null
)