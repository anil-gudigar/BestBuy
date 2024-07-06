package com.bestbuy.storelocator.data.model


import androidx.room.Entity
import androidx.room.TypeConverters
import com.bestbuy.storelocator.data.local.StoreTypeConverters
import com.google.gson.annotations.SerializedName
@Entity(tableName = "service")
@TypeConverters(StoreTypeConverters::class)
data class Service(
    @field:SerializedName("service")
    var service: String?
){
    override fun toString(): String {
        return "Service(service=$service)"
    }
}