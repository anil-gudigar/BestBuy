package com.bestbuy.discovery.data.model


import com.google.gson.annotations.SerializedName

data class IncludedItem(
    @SerializedName("includedItem")
    var includedItem: String?
)