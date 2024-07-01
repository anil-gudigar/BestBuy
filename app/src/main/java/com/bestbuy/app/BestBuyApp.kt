package com.bestbuy.app

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDex
import com.bestbuy.app.di.AppInjector
import com.bestbuy.core.BaseApp
import com.bestbuy.core.Contextor
import com.facebook.stetho.Stetho
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import timber.log.Timber
import javax.inject.Inject

/**
 * @Author: Anil Gudigar
 * @Date: 02/07/24
 */
class BestBuyApp: BaseApp(), HasAndroidInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    companion object {
        var context: Context? = null
        var instance: BestBuyApp? = null
        fun sharedInstance(): BestBuyApp {
            if (instance == null) {
                instance = BestBuyApp()
            }
            return instance as BestBuyApp
        }

        init {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        }
    }

    override fun androidInjector() = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        //Stetho helps debug network calls and database / preference values
        if (BuildConfig.DEBUG) Stetho.initializeWithDefaults(this)

        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())

        AppInjector.init(this)
    }


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
        setAppinstance()
    }

    private fun setAppinstance() {
        context = this
        Contextor.instance.init(this)
    }
}