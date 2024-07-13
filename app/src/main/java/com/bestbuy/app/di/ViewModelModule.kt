package com.bestbuy.app.di

import androidx.lifecycle.ViewModelProvider
import com.bestbuy.core.di.ViewModelFactory
import com.bestbuy.discovery.di.ProductViewModelModule
import com.bestbuy.storelocator.di.StoreViewModelModule
import dagger.Binds
import dagger.Module

/**
 * @Author: Anil Gudigar
 * @Date: 02/07/24
 */
@Suppress("unused")
@Module(includes = [StoreViewModelModule::class,ProductViewModelModule::class])
abstract class ViewModelModule{
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}