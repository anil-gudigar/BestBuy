package com.bestbuy.storelocator.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.bestbuy.storelocator.data.local.StoreTypeConverters
import com.google.gson.annotations.SerializedName
@Entity(tableName = "store")
@TypeConverters(StoreTypeConverters::class)
data class Store(
    @field:SerializedName("address")
    var address: String?,
    @field:SerializedName("address2")
    var address2: String?,
    @field:SerializedName("brand")
    var brand: String?,
    @field:SerializedName("city")
    var city: String?,
    @field:SerializedName("country")
    var country: String?,
    @field:SerializedName("fullPostalCode")
    var fullPostalCode: String?,
    @field:SerializedName("gmtOffset")
    var gmtOffset: Int?,
    @field:SerializedName("hours")
    var hours: String?,
    @field:SerializedName("hoursAmPm")
    var hoursAmPm: String?,
    @SerializedName("language")
    var language: String?,
    @field:SerializedName("lat")
    var lat: Double?,
    @field:SerializedName("lng")
    var lng: Double?,
    @field:SerializedName("locationType")
    var locationType: String?,
    @field:SerializedName("longName")
    var longName: String?,
    @field:SerializedName("name")
    var name: String?,
    @field:SerializedName("phone")
    var phone: String?,
    @field:SerializedName("postalCode")
    var postalCode: String?,
    @field:SerializedName("region")
    var region: String?,
    @field:SerializedName("services")
    var services: List<Service>?,
    @field:SerializedName("storeId")
    @PrimaryKey
    var storeId: Int?,
    @field:SerializedName("storeType")
    var storeType: String?,
    @field:SerializedName("tradeIn")
    var tradeIn: String?
){
    override fun toString(): String {
        return "Store(address=$address, address2=$address2, brand=$brand, city=$city, country=$country, fullPostalCode=$fullPostalCode, gmtOffset=$gmtOffset, hours=$hours, hoursAmPm=$hoursAmPm, language=$language, lat=$lat, lng=$lng, locationType=$locationType, longName=$longName, name=$name, phone=$phone, postalCode=$postalCode, region=$region, services=$services, storeId=$storeId, storeType=$storeType, tradeIn=$tradeIn)"
    }
}