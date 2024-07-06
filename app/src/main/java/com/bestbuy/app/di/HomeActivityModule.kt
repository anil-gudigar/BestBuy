package com.bestbuy.app.di

import com.bestbuy.app.HomeActivity
import com.bestbuy.storelocator.di.StoreLocatorBuilderModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @Author: Anil Gudigar
 * @Date: 02/07/24
 */
@Suppress("unused")
@Module
abstract class HomeActivityModule{
    @ContributesAndroidInjector(modules = [StoreLocatorBuilderModule::class])
    abstract fun contributeHomeActivity(): HomeActivity
}