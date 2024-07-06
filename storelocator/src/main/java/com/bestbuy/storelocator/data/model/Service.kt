package com.bestbuy.storelocator.data.model


import com.google.gson.annotations.SerializedName

data class Service(
    @SerializedName("service")
    var service: String?
){
    override fun toString(): String {
        return "Service(service=$service)"
    }
}