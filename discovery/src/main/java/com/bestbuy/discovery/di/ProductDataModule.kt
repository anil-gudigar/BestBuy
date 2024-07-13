package com.bestbuy.discovery.di

import android.app.Application
import com.bestbuy.core.di.CoreDataModule
import com.bestbuy.discovery.data.ProductRemoteDataSource
import com.bestbuy.discovery.data.ProductRepository
import com.bestbuy.discovery.data.remote.ProductService
import com.bestbuy.discovery.usecases.ProductUsecase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * @Author: Anil Gudigar
 * @Date: 13/07/24
 */
@Module(includes = [CoreDataModule::class])
class ProductDataModule {

    @Singleton
    @Provides
    fun provideProductUsecase(repository: ProductRepository): ProductUsecase {
        return ProductUsecase(repository)
    }

    @Singleton
    @Provides
    fun provideProductRepository(
        remoteDataSource: ProductRemoteDataSource
    ): ProductRepository {
        return ProductRepository(remoteDataSource)
    }


    @Provides
    fun provideProductService(retrofit: Retrofit): ProductService =
        retrofit.create(ProductService::class.java)
}