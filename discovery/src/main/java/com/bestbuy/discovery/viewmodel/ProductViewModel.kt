package com.bestbuy.discovery.viewmodel

import android.app.Application
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.bestbuy.core.viewmodel.BaseViewModel
import com.bestbuy.discovery.data.model.Product
import com.bestbuy.discovery.usecases.ProductUsecase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author: Anil Gudigar
 * @Date: 13/07/24
 */
class ProductViewModel @ExperimentalCoroutinesApi @Inject constructor(application: Application) :
    BaseViewModel(application) {

    @Inject
    lateinit var productUsecase: ProductUsecase

    private var currentSearchResult: Flow<PagingData<Product>>? = null

    fun getProducts(): Flow<PagingData<Product>> {
        val newResult: Flow<PagingData<Product>> = productUsecase.getProducts()
            .cachedIn(viewModelScope)
        currentSearchResult = newResult
        return newResult
    }
}