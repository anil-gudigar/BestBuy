package com.bestbuy.app.di

import androidx.lifecycle.ViewModelProvider
import com.bestbuy.core.di.ViewModelFactory
import dagger.Binds
import dagger.Module

/**
 * @Author: Anil Gudigar
 * @Date: 02/07/24
 */
@Suppress("unused")
@Module
abstract class ViewModelModule{
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}