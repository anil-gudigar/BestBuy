package com.bestbuy.storelocator.view.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bestbuy.storelocator.data.model.Store
import com.bestbuy.storelocator.databinding.ListItemStoreBinding

/**
 * @Author: Anil Gudigar
 * @Date: 05/07/24
 */
class StoresAdapter(private val listener: StoresClickListener) :
    PagingDataAdapter<Store, StoresAdapter.ViewHolder>(DiffCallback()) {
    val ARG_STOREID = "storeId"

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val store = getItem(position)
        holder.apply {
            if (store != null) {
                store.storeId?.let { createOnClickListener(it) }?.let { bind(it, store) }
            }
            itemView.tag = store
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemStoreBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    private fun createOnClickListener(id: Int): View.OnClickListener {
        return View.OnClickListener {
            val args = Bundle()
            args.putInt(ARG_STOREID, id)
            listener.onStoreClicked(args)
        }
    }

    class ViewHolder(
        private val binding: ListItemStoreBinding
    ) : RecyclerView.ViewHolder(binding.storeItem) {
        fun bind(listener: View.OnClickListener, item: Store) {
            binding.apply {
                clickListener = listener
                this.store = item
            }
        }
    }

    interface StoresClickListener {
        fun onStoreClicked(item: Bundle)
    }
}

private class DiffCallback : DiffUtil.ItemCallback<Store>() {

    override fun areItemsTheSame(oldItem: Store, newItem: Store): Boolean {
        return oldItem.storeId == newItem.storeId
    }

    override fun areContentsTheSame(oldItem: Store, newItem: Store): Boolean {
        return oldItem == newItem
    }
}