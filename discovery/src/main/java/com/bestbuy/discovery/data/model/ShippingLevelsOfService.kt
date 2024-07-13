package com.bestbuy.discovery.data.model


import com.google.gson.annotations.SerializedName

data class ShippingLevelsOfService(
    @SerializedName("serviceLevelId")
    var serviceLevelId: Int?,
    @SerializedName("serviceLevelName")
    var serviceLevelName: String?,
    @SerializedName("unitShippingPrice")
    var unitShippingPrice: Any?
)