package com.bestbuy.discovery.view.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bestbuy.discovery.data.model.Product
import com.bestbuy.discovery.databinding.ListItemProductBinding

/**
 * @Author: Anil Gudigar
 * @Date: 13/07/24
 */
class ProductAdapter(private val listener: ProductClickListener) :
    PagingDataAdapter<Product, ProductAdapter.ViewHolder>(DiffCallback()) {
    val ARG_SKU = "sku"

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = getItem(position)
        holder.apply {
            if (product != null) {
                product.sku?.let { createOnClickListener(it) }?.let { bind(it, product) }
            }
            itemView.tag = product
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    private fun createOnClickListener(id: Int): View.OnClickListener {
        return View.OnClickListener {
            val args = Bundle()
            args.putInt(ARG_SKU, id)
            listener.onProductClicked(args)
        }
    }

    class ViewHolder(
        private val binding: ListItemProductBinding
    ) : RecyclerView.ViewHolder(binding.productItem) {
        fun bind(listener: View.OnClickListener, item: Product) {
            binding.apply {
                clickListener = listener
                this.product = item
            }
        }
    }

    interface ProductClickListener {
        fun onProductClicked(item: Bundle)
    }
}

private class DiffCallback : DiffUtil.ItemCallback<Product>() {

    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.productId == newItem.productId
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }
}