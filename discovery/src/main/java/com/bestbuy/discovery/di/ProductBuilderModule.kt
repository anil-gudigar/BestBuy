package com.bestbuy.discovery.di

import com.bestbuy.discovery.view.ProductFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @Author: Anil Gudigar
 * @Date: 13/07/24
 */
@Module
abstract class ProductBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeProductFragment(): ProductFragment
}