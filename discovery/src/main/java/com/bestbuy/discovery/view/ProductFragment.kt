package com.bestbuy.discovery.view

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bestbuy.core.di.Injectable
import com.bestbuy.core.di.injectViewModel
import com.bestbuy.core.view.BaseViewModelFragment
import com.bestbuy.discovery.R
import com.bestbuy.discovery.view.adapters.ProductAdapter
import com.bestbuy.discovery.viewmodel.ProductViewModel
import com.bestbuy.discovery.databinding.ProductFragmentBinding
import com.bestbuy.stylekit.ui.GridItemDecoration
import com.bestbuy.stylekit.ui.hide
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @Author: Anil Gudigar
 * @Date: 13/07/24
 */
class ProductFragment : BaseViewModelFragment<ProductFragmentBinding, ProductViewModel>(),
    ProductAdapter.ProductClickListener
    , Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun getLayout(): Int {
        return R.layout.product_fragment
    }

    override fun initView() {
        viewModel = injectViewModel(viewModelFactory)
        binding.lifecycleOwner = this
        binding.vm = viewModel
        val adapter = ProductAdapter(this)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
        val dividerItemDecoration = DividerItemDecoration(
            binding.recyclerView.getContext(),
            DividerItemDecoration.VERTICAL
        )
        binding.recyclerView.addItemDecoration(dividerItemDecoration);
        subscribeUi(binding, adapter)
    }

    override fun navigateTo(pageName: String, bundle: Bundle) {
    }

    private fun subscribeUi(binding: ProductFragmentBinding, adapter: ProductAdapter) {
        lifecycleScope.launch {
            viewModel.getProducts().collectLatest { pagingData ->
                binding.progressBar.hide()
                adapter.submitData(pagingData)
            }
        }
    }

    override fun onProductClicked(item: Bundle) {
        //navigateTo(Navigation.ScreenName.PRODUCT_DETAILS, item)
    }
}
