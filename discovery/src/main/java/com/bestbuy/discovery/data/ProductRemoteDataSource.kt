package com.bestbuy.discovery.data

import androidx.paging.PagingSource
import com.bestbuy.core.BuildConfig
import com.bestbuy.discovery.data.model.Product
import com.bestbuy.discovery.data.remote.ProductService
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * @Author: Anil Gudigar
 * @Date: 13/07/24
 */
class ProductRemoteDataSource @Inject constructor(private val service: ProductService) :
    PagingSource<Int, Product>() {
    private val STARTING_PAGE_INDEX = 1

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Product> {
        val position = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response = service.getAllProducts(
                BuildConfig.API_DEVELOPER_TOKEN,
                "json",
                position
            )
            var stores: List<Product> = arrayListOf()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    stores = body.products ?: arrayListOf()
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