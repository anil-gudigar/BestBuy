package com.bestbuy.storelocator.di

import com.bestbuy.storelocator.view.StoresFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @Author: Anil Gudigar
 * @Date: 06/07/24
 */
@Module
abstract class StoreLocatorBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeStoresFragment(): StoresFragment
}