package com.bestbuy.discovery.data.model


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("height")
    var height: String?,
    @SerializedName("href")
    var href: String?,
    @SerializedName("primary")
    var primary: Boolean?,
    @SerializedName("rel")
    var rel: String?,
    @SerializedName("unitOfMeasure")
    var unitOfMeasure: String?,
    @SerializedName("width")
    var width: String?
)