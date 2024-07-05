package com.bestbuy.core.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection

/**
 * @Author: Anil Gudigar
 * @Date: 01/07/24
 */
abstract class BaseFragment: Fragment() {

    companion object {
        var TAG = "BaseFragment"
    }

    protected val fragmentArguments: Bundle?
        get() = arguments


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        TAG = this.javaClass.simpleName
        return bindView(inflater, container)
    }

    protected abstract fun bindView(inflater: LayoutInflater, container: ViewGroup?): View

    abstract fun navigateTo(pageName: String, bundle: Bundle)

    fun navigate(screenName: String, bundle: Bundle) {
        if (activity is BaseActivity) {
            (activity as BaseActivity).navigate(screenName, bundle)
        }
    }

    fun hideBottomNav() {
        if (activity is BaseActivity) {
            (activity as BaseActivity).hideBottomNav()
        }
    }

    fun showBottomNav() {
        if (activity is BaseActivity) {
            (activity as BaseActivity).showBottomNav()
        }
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

}