package com.bestbuy.storelocator.data.di

import com.bestbuy.storelocator.data.view.StoresFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @Author: Anil Gudigar
 * @Date: 05/07/24
 */
@Module
abstract class StoresBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeStoresFragment(): StoresFragment
}