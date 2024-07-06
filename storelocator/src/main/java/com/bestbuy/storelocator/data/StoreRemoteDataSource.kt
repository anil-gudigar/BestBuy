package com.bestbuy.storelocator.data

import androidx.paging.PagingSource
import com.bestbuy.storelocator.data.model.Stores
import com.bestbuy.storelocator.data.remote.StoreLocatorService
import com.bestbuy.core.BuildConfig
import com.bestbuy.storelocator.data.model.Store
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * @Author: Anil Gudigar
 * @Date: 05/07/24
 */
class StoreRemoteDataSource @Inject constructor(private val service: StoreLocatorService) :
    PagingSource<Int, Store>() {
    private val STARTING_PAGE_INDEX = 1

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Store> {
        val position = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response = service.getStoreList(
                BuildConfig.API_DEVELOPER_TOKEN,
                "json",
                position
            )
            var stores: List<Store> = arrayListOf()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    stores = body.stores ?: arrayListOf()
                }
            }
            LoadResult.Page(
                data = stores,
                prevKey = if (position == STARTING_PAGE_INDEX) null else position,
                nextKey = if (stores.isEmpty()) null else position + 1

            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

}