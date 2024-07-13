package com.bestbuy.discovery.di

import androidx.lifecycle.ViewModel
import com.bestbuy.core.di.ViewModelKey
import com.bestbuy.discovery.viewmodel.ProductViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @Author: Anil Gudigar
 * @Date: 13/07/24
 */
@Module
abstract class ProductViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ProductViewModel::class)
    abstract fun bindProductViewModel(viewModel: ProductViewModel): ViewModel
}