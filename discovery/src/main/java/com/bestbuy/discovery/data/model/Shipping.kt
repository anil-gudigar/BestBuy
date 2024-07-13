package com.bestbuy.discovery.data.model


import com.google.gson.annotations.SerializedName

data class Shipping(
    @SerializedName("ground")
    var ground: Any?,
    @SerializedName("nextDay")
    var nextDay: Any?,
    @SerializedName("secondDay")
    var secondDay: Any?,
    @SerializedName("vendorDelivery")
    var vendorDelivery: String?
)