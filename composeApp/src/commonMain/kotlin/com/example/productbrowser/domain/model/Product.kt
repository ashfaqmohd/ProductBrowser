package com.example.productbrowser.domain.model

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val brand: String,
    val rating: Double,
    val price: Double,
    val thumbnail: String
)