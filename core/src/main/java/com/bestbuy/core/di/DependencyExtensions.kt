package com.bestbuy.core.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

/**
 * @Author: Anil Gudigar
 * @Date: 02/07/24
 */
/**
 * Kotlin extensions for dependency injection
 */
inline fun <reified T : ViewModel> Fragment.injectViewModel(factory: ViewModelProvider.Factory): T {
    return ViewModelProviders.of(requireActivity(), factory)[T::class.java]
}