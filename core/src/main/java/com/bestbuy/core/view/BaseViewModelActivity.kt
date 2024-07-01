package com.bestbuy.core.view

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.bestbuy.core.data.DataWrapper
import com.bestbuy.core.viewmodel.BaseViewModel
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * @Author: Anil Gudigar
 * @Date: 01/07/24
 */
abstract class BaseViewModelActivity<B : ViewDataBinding, VM : BaseViewModel> : BaseActivity(),
    HasSupportFragmentInjector {

    protected var viewModel: VM? = null
    protected lateinit var binding: B
    lateinit var TAG: String

    @Inject
    lateinit var supportFragmentInjector: DispatchingAndroidInjector<Fragment>

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

    override fun supportFragmentInjector(): DispatchingAndroidInjector<Fragment>? {
        return supportFragmentInjector
    }
}