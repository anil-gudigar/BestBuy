package com.bestbuy.storelocator.data.local

import androidx.room.TypeConverter
import com.bestbuy.storelocator.data.model.Service
import com.bestbuy.storelocator.data.model.Store
import com.google.gson.Gson

/**
 * @Author: Anil Gudigar
 * @Date: 06/07/24
 */
class StoreTypeConverters {
    @TypeConverter
    fun jsonStoreToList(value: String): List<Store>? {
        var list = listOf<Store>()
        if (!Gson().fromJson(value, Array<Store>::class.java).isNullOrEmpty()) {
            val objects = Gson().fromJson(value, Array<Store>::class.java) as Array<Store>
            list = objects.toList()
        }
        return list
    }

    @TypeConverter
    fun listStoreToJson(value: List<Store>?): String {
        return Gson().toJson(value)
    }


    @TypeConverter
    fun jsonServiceToList(value: String): List<Service>? {
        var list = listOf<Service>()
        if (!Gson().fromJson(value, Array<Service>::class.java).isNullOrEmpty()) {
            val objects = Gson().fromJson(value, Array<Store>::class.java) as Array<Service>
            list = objects.toList()
        }
        return list
    }

    @TypeConverter
    fun listServiceToJson(value: List<Service>?): String {
        return Gson().toJson(value)
    }
}