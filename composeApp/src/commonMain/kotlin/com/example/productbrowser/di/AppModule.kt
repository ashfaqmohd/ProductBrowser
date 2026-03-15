package com.example.productbrowser.di

import com.example.productbrowser.data.repository.ProductRepositoryImpl
import com.example.productbrowser.domain.repository.ProductRepository
import com.example.productbrowser.domain.usecase.product.GetProductDetailUseCase
import com.example.productbrowser.domain.usecase.product.GetProductsUseCase
import com.example.productbrowser.domain.usecase.product.SearchProductsUseCase
import com.example.productbrowser.network.ApiService
import com.example.productbrowser.network.provideHttpClient
import com.example.productbrowser.ui.product.ProductDetailViewModel
import com.example.productbrowser.ui.product.ProductViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { provideHttpClient() }

    single { ApiService(get()) }

    single<ProductRepository> { ProductRepositoryImpl(get()) }

    factory { GetProductsUseCase(get()) }

    factory { GetProductDetailUseCase(get()) }

    factory { SearchProductsUseCase(get()) }

    viewModel {
        ProductViewModel(get(), get())
    }

    viewModel {
        ProductDetailViewModel(get() )
    }
}