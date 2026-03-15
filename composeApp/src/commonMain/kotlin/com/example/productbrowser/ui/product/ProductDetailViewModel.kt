package com.example.productbrowser.ui.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productbrowser.data.remote.NetworkResult
import com.example.productbrowser.domain.usecase.product.GetProductDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductDetailViewModel(
    private val getProductDetails: GetProductDetailUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(ProductDetailUiState())
    val uiState: StateFlow<ProductDetailUiState> = _uiState

    fun productDetails(id: Int) {

        viewModelScope.launch(Dispatchers.IO) {

            _uiState.value = ProductDetailUiState(isLoading = true)

            when(val result = getProductDetails(id)) {

                is NetworkResult.Success -> {
                    _uiState.value = ProductDetailUiState(
                        product = result.data
                    )
                }

                is NetworkResult.Error -> {
                    _uiState.value = ProductDetailUiState(
                        error = result.message
                    )
                }
            }
        }
    }
}