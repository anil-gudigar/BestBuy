package com.bestbuy.storelocator.data.di

import android.app.Application
import com.bestbuy.core.di.CoreDataModule
import com.bestbuy.storelocator.data.StoreRemoteDataSource
import com.bestbuy.storelocator.data.StoresRepository
import com.bestbuy.storelocator.data.db.StoresDatabase
import com.bestbuy.storelocator.data.local.StoreDao
import com.bestbuy.storelocator.data.remote.StoreLocatorService
import com.bestbuy.storelocator.data.usecases.StoresUsecase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * @Author: Anil Gudigar
 * @Date: 05/07/24
 */

@Module(includes = [CoreDataModule::class])
class StoreDataModule {
    @Singleton
    @Provides
    fun provideDb(app: Application) = StoresDatabase.getInstance(app)


    @Singleton
    @Provides
    fun provideStoreDao(db: StoresDatabase): StoreDao {
        return db.storeDao()
    }

    @Singleton
    @Provides
    fun provideStoreUsecase(repository: StoresRepository): StoresUsecase {
        return StoresUsecase(repository)
    }

    @Singleton
    @Provides
    fun provideStoreRepository(
        dao: StoreDao,
        remoteDataSource: StoreRemoteDataSource
    ): StoresRepository {
        return StoresRepository(dao, remoteDataSource)
    }


    @Provides
    fun provideStoreLocatorService(retrofit: Retrofit): StoreLocatorService =
        retrofit.create(StoreLocatorService::class.java)

}