package com.bestbuy.storelocator.data.usecases

import androidx.paging.PagingData
import com.bestbuy.storelocator.data.StoresRepository
import com.bestbuy.storelocator.data.model.Store
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author: Anil Gudigar
 * @Date: 05/07/24
 */
class StoresUsecase  @Inject constructor(val storesRepository: StoresRepository) {
    fun getStores(): Flow<PagingData<Store>> {
        return storesRepository.getStores()
    }
}