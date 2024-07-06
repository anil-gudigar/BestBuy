package com.bestbuy.storelocator.data.remote

import com.bestbuy.storelocator.data.model.Stores
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @Author: Anil Gudigar
 * @Date: 05/07/24
 */
interface StoreLocatorService {
    @GET("stores")
    suspend fun getStoreList(
        @Query("apiKey") apiKey: String? = null,
        @Query("format") format: String? = null,
        @Query("page") page: Int? = null
    ): Response<Stores>
}