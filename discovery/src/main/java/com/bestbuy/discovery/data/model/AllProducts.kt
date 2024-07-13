package com.bestbuy.discovery.data.model


import com.google.gson.annotations.SerializedName

data class AllProducts(
    @SerializedName("canonicalUrl")
    var canonicalUrl: String?,
    @SerializedName("currentPage")
    var currentPage: Int?,
    @SerializedName("from")
    var from: Int?,
    @SerializedName("partial")
    var partial: Boolean?,
    @SerializedName("products")
    var products: List<Product>?,
    @SerializedName("queryTime")
    var queryTime: String?,
    @SerializedName("to")
    var to: Int?,
    @SerializedName("total")
    var total: Int?,
    @SerializedName("totalPages")
    var totalPages: Int?,
    @SerializedName("totalTime")
    var totalTime: String?
)