package com.bestbuy.storelocator.data.view

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.bestbuy.core.di.Injectable
import com.bestbuy.core.di.injectViewModel
import com.bestbuy.core.navigation.Navigation
import com.bestbuy.core.view.BaseViewModelFragment
import com.bestbuy.storelocator.R
import com.bestbuy.storelocator.data.view.adapters.StoresAdapter
import com.bestbuy.storelocator.data.viewmodel.StoresViewModel
import com.bestbuy.storelocator.databinding.StoresFragmentBinding
import com.bestbuy.stylekit.ui.hide
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @Author: Anil Gudigar
 * @Date: 05/07/24
 */
class StoresFragment : BaseViewModelFragment<StoresFragmentBinding, StoresViewModel>(),
    StoresAdapter.StoresClickListener
    , Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun getLayout(): Int {
        return R.layout.stores_fragment
    }

    override fun initView() {
        viewModel = injectViewModel(viewModelFactory)
        binding.lifecycleOwner = this
        binding.vm = viewModel
        val adapter = StoresAdapter(this)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = GridLayoutManager(context, 2)
        binding.recyclerView.adapter = adapter
        subscribeUi(binding, adapter)
    }

    override fun navigateTo(pageName: String, bundle: Bundle) {
    }

    private fun subscribeUi(binding: StoresFragmentBinding, adapter: StoresAdapter) {
        lifecycleScope.launch {
            viewModel.getStores().collectLatest { pagingData ->
                binding.progressBar.hide()
                adapter.submitData(pagingData)
            }
        }
    }

    override fun onStoreClicked(item: Bundle) {
        //navigateTo(Navigation.ScreenName.STORE_DETAILS, item)
    }
}
