package com.example.productbrowser.data.repository

import com.example.productbrowser.data.mapper.toDomain
import com.example.productbrowser.data.remote.NetworkResult
import com.example.productbrowser.domain.model.Product
import com.example.productbrowser.domain.repository.ProductRepository
import com.example.productbrowser.network.ApiService

class ProductRepositoryImpl(
    private val apiService: ApiService
) : ProductRepository {

    override suspend fun getProducts(): NetworkResult<List<Product>> {
        return try {
            val response = apiService.getProducts().products
            NetworkResult.Success(response.map { it.toDomain() })
        } catch (e: Exception) {
            NetworkResult.Error(e.message ?: "Unknown error")
        }
    }

    override suspend fun getProductDetail(id: Int): NetworkResult<Product> {
        return try {
            val response = apiService.getProductDetail(id)
            NetworkResult.Success(response.toDomain() )
        } catch (e: Exception) {
            NetworkResult.Error(e.message ?: "Unknown error")
        }
    }
    override suspend fun searchProducts(query: String): NetworkResult<List<Product>> {
        return try {
            val response =  apiService.searchProducts(query)
            NetworkResult.Success(response.products.map { it.toDomain() } )
        } catch (e: Exception) {
            NetworkResult.Error(e.message ?: "Unknown error")
        }
    }
}