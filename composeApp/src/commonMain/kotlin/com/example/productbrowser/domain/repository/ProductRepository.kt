package com.example.productbrowser.domain.repository

import com.example.productbrowser.data.remote.NetworkResult
import com.example.productbrowser.domain.model.Product

interface ProductRepository {
    suspend fun getProducts(): NetworkResult<List<Product>>
    suspend fun getProductDetail(id: Int): NetworkResult<Product>
    suspend fun searchProducts(query: String): NetworkResult<List<Product>>
}