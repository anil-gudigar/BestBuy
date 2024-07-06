package com.bestbuy.storelocator.data.model


import androidx.room.TypeConverters
import com.bestbuy.storelocator.data.local.StoreTypeConverters
import com.google.gson.annotations.SerializedName

@TypeConverters(StoreTypeConverters::class)
data class Stores(
    @SerializedName("canonicalUrl")
    var canonicalUrl: String?,
    @SerializedName("currentPage")
    var currentPage: Int?,
    @SerializedName("from")
    var from: Int?,
    @SerializedName("partial")
    var partial: Boolean?,
    @SerializedName("queryTime")
    var queryTime: String?,
    @SerializedName("stores")
    var stores: List<Store>?,
    @SerializedName("to")
    var to: Int?,
    @SerializedName("total")
    var total: Int?,
    @SerializedName("totalPages")
    var totalPages: Int?,
    @SerializedName("totalTime")
    var totalTime: String?
){
    override fun toString(): String {
        return "Stores(canonicalUrl=$canonicalUrl, currentPage=$currentPage, from=$from, partial=$partial, queryTime=$queryTime, stores=$stores, to=$to, total=$total, totalPages=$totalPages, totalTime=$totalTime)"
    }
}