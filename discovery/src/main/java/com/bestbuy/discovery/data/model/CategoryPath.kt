package com.bestbuy.discovery.data.model


import com.google.gson.annotations.SerializedName

data class CategoryPath(
    @SerializedName("id")
    var id: String?,
    @SerializedName("name")
    var name: String?
)