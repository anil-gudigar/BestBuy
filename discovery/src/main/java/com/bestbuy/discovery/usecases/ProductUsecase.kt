package com.bestbuy.discovery.usecases

import androidx.paging.PagingData
import com.bestbuy.discovery.data.ProductRepository
import com.bestbuy.discovery.data.model.Product
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author: Anil Gudigar
 * @Date: 13/07/24
 */
class ProductUsecase @Inject constructor(val productRepository: ProductRepository) {
    fun getProducts(): Flow<PagingData<Product>> {
        return productRepository.getProducts()
    }
}