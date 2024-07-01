package com.bestbuy.app.di

import com.bestbuy.core.di.CoreDataModule
import dagger.Module

/**
 * @Author: Anil Gudigar
 * @Date: 02/07/24
 */
@Module(
    includes = [ViewModelModule::class, CoreDataModule::class]
)
class AppModule