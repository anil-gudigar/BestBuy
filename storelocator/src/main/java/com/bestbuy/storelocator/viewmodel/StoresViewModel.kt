package com.bestbuy.storelocator.viewmodel

import android.app.Application
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.bestbuy.core.viewmodel.BaseViewModel
import com.bestbuy.storelocator.data.model.Store
import com.bestbuy.storelocator.usecases.StoresUsecase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author: Anil Gudigar
 * @Date: 05/07/24
 */
class StoresViewModel @ExperimentalCoroutinesApi @Inject constructor(application: Application) :
    BaseViewModel(application) {

    @Inject
    lateinit var storesUsecase: StoresUsecase

    private var currentSearchResult: Flow<PagingData<Store>>? = null

    fun getStores(): Flow<PagingData<Store>> {
        val newResult: Flow<PagingData<Store>> = storesUsecase.getStores()
            .cachedIn(viewModelScope)
        currentSearchResult = newResult
        return newResult
    }
}