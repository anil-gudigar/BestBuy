package com.bestbuy.storelocator.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.bestbuy.storelocator.data.local.StoreDao
import com.bestbuy.storelocator.data.model.Store
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author: Anil Gudigar
 * @Date: 05/07/24
 */
class StoresRepository@Inject constructor(
    private val dao: StoreDao,
    private val remoteSource: StoreRemoteDataSource
) {
    companion object {
        private const val NETWORK_PAGE_SIZE = 1000

    }

    //TODO: Save in local DB
    fun getStores(): Flow<PagingData<Store>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = true
            ),
            pagingSourceFactory = { remoteSource }
        ).flow
    }
}