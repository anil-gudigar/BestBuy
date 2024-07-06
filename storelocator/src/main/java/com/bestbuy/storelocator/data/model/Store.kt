package com.bestbuy.storelocator.data.model


import androidx.databinding.adapters.Converters
import androidx.room.Entity
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
@Entity(tableName = "store")
@TypeConverters(Converters::class)
data class Store(
    @SerializedName("address")
    var address: String?,
    @SerializedName("address2")
    var address2: String?,
    @SerializedName("brand")
    var brand: Any?,
    @SerializedName("city")
    var city: String?,
    @SerializedName("country")
    var country: String?,
    @SerializedName("fullPostalCode")
    var fullPostalCode: String?,
    @SerializedName("gmtOffset")
    var gmtOffset: Int?,
    @SerializedName("hours")
    var hours: String?,
    @SerializedName("hoursAmPm")
    var hoursAmPm: String?,
    @SerializedName("language")
    var language: Any?,
    @SerializedName("lat")
    var lat: Double?,
    @SerializedName("lng")
    var lng: Double?,
    @SerializedName("locationType")
    var locationType: String?,
    @SerializedName("longName")
    var longName: String?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("phone")
    var phone: String?,
    @SerializedName("postalCode")
    var postalCode: String?,
    @SerializedName("region")
    var region: String?,
    @SerializedName("services")
    var services: List<Service>?,
    @SerializedName("storeId")
    var storeId: Int?,
    @SerializedName("storeType")
    var storeType: String?,
    @SerializedName("tradeIn")
    var tradeIn: Any?
){
    override fun toString(): String {
        return "Store(address=$address, address2=$address2, brand=$brand, city=$city, country=$country, fullPostalCode=$fullPostalCode, gmtOffset=$gmtOffset, hours=$hours, hoursAmPm=$hoursAmPm, language=$language, lat=$lat, lng=$lng, locationType=$locationType, longName=$longName, name=$name, phone=$phone, postalCode=$postalCode, region=$region, services=$services, storeId=$storeId, storeType=$storeType, tradeIn=$tradeIn)"
    }
}