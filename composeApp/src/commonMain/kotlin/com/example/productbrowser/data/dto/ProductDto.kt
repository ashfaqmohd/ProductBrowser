package com.example.productbrowser.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class ProductResDto(
    val products: List<ProductDto>
)

@Serializable
data class ProductDto(
    val id: Int,
    val title: String,
    val description: String,
    val brand: String? = null,
    val rating: Double = 0.0,
    val price: Double,
    val thumbnail: String
)