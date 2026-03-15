package com.example.productbrowser.network

import com.example.productbrowser.data.dto.ProductDto
import com.example.productbrowser.data.dto.ProductResDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ApiService(
    private val client: HttpClient
) {

    suspend fun getProducts(): ProductResDto {
        return client.get("https://dummyjson.com/products").body()
    }

    suspend fun getProductDetail(id: Int): ProductDto {
        return client.get("https://dummyjson.com/products/$id").body()
    }

    suspend fun searchProducts(query: String): ProductResDto {
        return client.get("https://dummyjson.com/products/search?q=$query").body()
    }
}