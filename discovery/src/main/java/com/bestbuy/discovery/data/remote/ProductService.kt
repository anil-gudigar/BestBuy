package com.bestbuy.discovery.data.remote

import com.bestbuy.discovery.data.model.AllProducts
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @Author: Anil Gudigar
 * @Date: 13/07/24
 */
interface ProductService {
    @GET("products")
    suspend fun getAllProducts(
        @Query("apiKey") apiKey: String? = null,
        @Query("format") format: String? = null,
        @Query("page") page: Int? = null
    ): Response<AllProducts>
}