package com.example.productbrowser.ui.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productbrowser.data.remote.NetworkResult
import com.example.productbrowser.domain.usecase.product.GetProductsUseCase
import com.example.productbrowser.domain.usecase.product.SearchProductsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel(
    private val getProducts: GetProductsUseCase,
    private val searchProducts: SearchProductsUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(ProductListUiState())
    val uiState: StateFlow<ProductListUiState> = _uiState

    init {
        loadProducts()
    }

    fun loadProducts() {

        viewModelScope.launch(Dispatchers.IO) {

            _uiState.value = ProductListUiState(isLoading = true)

            when(val result = getProducts()) {

                is NetworkResult.Success -> {
                    _uiState.value = ProductListUiState(
                        products = result.data
                    )
                }

                is NetworkResult.Error -> {
                    _uiState.value = ProductListUiState(
                        error = result.message
                    )
                }
            }
        }
    }

    fun search(query: String) {

        _uiState.value = ProductListUiState(isLoading = true)

        viewModelScope.launch(Dispatchers.IO) {

            when (val result = searchProducts(query)) {

                is NetworkResult.Success -> {
                    _uiState.value =
                        ProductListUiState(products = result.data)
                }

                is NetworkResult.Error -> {
                    _uiState.value =
                        ProductListUiState(error = result.message)
                }
            }
        }
    }
}