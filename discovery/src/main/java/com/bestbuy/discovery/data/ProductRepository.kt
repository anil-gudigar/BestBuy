package com.bestbuy.discovery.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.bestbuy.discovery.data.model.Product
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author: Anil Gudigar
 * @Date: 13/07/24
 */
class ProductRepository @Inject constructor(private val remoteSource: ProductRemoteDataSource) {
    companion object {
        private const val NETWORK_PAGE_SIZE = 1000

    }

    fun getProducts(): Flow<PagingData<Product>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = true
            ),
            pagingSourceFactory = { remoteSource }
        ).flow
    }
}