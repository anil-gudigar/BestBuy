package com.bestbuy.core

import android.app.Application

/**
 * @Author: Anil Gudigar
 * @Date: 02/07/24
 */
class Contextor {
    var context: Application? = null

    fun init(pContext: Application) {
        context = pContext
    }

    companion object {

        private var sInstance: Contextor? = null

        val instance: Contextor
            get() {
                if (sInstance == null) {
                    sInstance = Contextor()
                }
                return sInstance!!
            }
    }
}