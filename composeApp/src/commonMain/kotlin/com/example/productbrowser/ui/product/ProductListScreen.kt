package com.example.productbrowser.ui.product

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.productbrowser.common.customUi.SearchBar
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ProductListScreen(
    viewModel: ProductViewModel = koinViewModel(),
    onProductClick: (Int) -> Unit
) {

    val state by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.systemBarsPadding()
    ) {

        SearchBar(
            onSearch = {
                viewModel.search(it)
            }
        )

        when {

            state.isLoading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            state.error != null -> {
                Text(state.error!!)
            }

            else -> {
                ProductList(
                    products = state.products,
                    onProductClick = onProductClick
                )
            }
        }
    }
}