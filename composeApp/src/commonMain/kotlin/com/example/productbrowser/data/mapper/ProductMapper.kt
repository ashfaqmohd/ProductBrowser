package com.example.productbrowser.data.mapper

import com.example.productbrowser.data.dto.ProductDto
import com.example.productbrowser.domain.model.Product

fun ProductDto.toDomain(): Product {
    return Product(
        id = id,
        name = title,
        price = price,
        thumbnail = thumbnail,
        brand = brand?:"",
        description = description,
        rating = rating
    )
}