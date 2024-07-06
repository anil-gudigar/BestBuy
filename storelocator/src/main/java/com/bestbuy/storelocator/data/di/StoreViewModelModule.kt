package com.bestbuy.storelocator.data.di

import androidx.lifecycle.ViewModel
import com.bestbuy.core.di.ViewModelKey
import com.bestbuy.storelocator.data.viewmodel.StoresViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @Author: Anil Gudigar
 * @Date: 05/07/24
 */
@Module
abstract class StoreViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(StoresViewModel::class)
    abstract fun bindStoresViewModel(viewModel: StoresViewModel): ViewModel
}