package com.bestbuy.core.view

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.bestbuy.core.data.DataWrapper
import com.bestbuy.core.viewmodel.BaseViewModel
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * @Author: Anil Gudigar
 * @Date: 01/07/24
 */
abstract class BaseViewModelActivity<B : ViewDataBinding, VM : BaseViewModel> : BaseActivity(),
    HasAndroidInjector {

    protected var viewModel: VM? = null
    protected lateinit var binding: B
    lateinit var TAG: String

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TAG = javaClass.simpleName
        //init data binding
        binding = DataBindingUtil.setContentView(this, layout)
        initViews()
    }

    protected abstract fun initViews()

    override fun shouldUseDataBinding(): Boolean {
        return true
    }

    /**
     * Default state handling, can be override
     * This method will be called when viewmodel returns the livedata
     *
     * @param wrapper
     */
    protected fun handleState(wrapper: DataWrapper<Any>?) {
        setLoading(wrapper != null && wrapper.status.equals(DataWrapper.Status.LOADING))
        handleData(wrapper)
    }

    protected abstract fun handleData(dataWrapper: DataWrapper<Any>?)

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}