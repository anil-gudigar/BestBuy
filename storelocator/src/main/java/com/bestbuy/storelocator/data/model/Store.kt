package com.bestbuy.storelocator.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.bestbuy.storelocator.data.local.StoreTypeConverters
import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

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
    fun getFullAddress():String{
        return "$address,$address2\n$city,$country,$postalCode"
    }

    // Function to calculate if the location is open now and return hours or "Closed"
    fun isOpenNow(): String {
        // Parse the opening hours string
        val openingHours = hoursAmPm?.let { parseOpeningHours(it) }
        val prefix = "Today's hours :"
        // Get the current day of the week and time
        val calendar = Calendar.getInstance()
        val currentDay = calendar.get(Calendar.DAY_OF_WEEK)
        val currentTime = calendar.get(Calendar.HOUR_OF_DAY) * 100 + calendar.get(Calendar.MINUTE)

        // Check if current time falls within any of the opening hour ranges for the current day
        openingHours?.get(currentDay)?.forEach { (startTime, endTime) ->
            if (currentTime >= startTime && currentTime <= endTime) {
                return prefix+"${formatTime(startTime)}-${formatTime(endTime)}"
            }
        }
        return prefix+"Closed"
    }

    // Function to calculate if the location will be open tomorrow and return hours or "Closed"
    fun isTomorrowOpen(): String {
        // Parse the opening hours string
        val openingHours = hoursAmPm?.let { parseOpeningHours(it) }
        val prefix = "Tomorrow's hours :"
        // Get tomorrow's day of the week
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, 1)
        val tomorrowDay = calendar.get(Calendar.DAY_OF_WEEK)

        // Check if there are any opening hours for tomorrow
        val tomorrowOpeningHours = openingHours?.get(tomorrowDay)
        if (tomorrowOpeningHours != null && tomorrowOpeningHours.isNotEmpty()) {
            val (startTime, endTime) = tomorrowOpeningHours[0] // Assuming a single range for simplicity
            return prefix+"${formatTime(startTime)}-${formatTime(endTime)}"
        }

        return prefix+"Closed"
    }


    // Function to format time from 24-hour format to AM/PM format
    fun formatTime(time: Int): String {
        val hour = time / 100
        val minute = time % 100
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, hour)
        calendar.set(Calendar.MINUTE, minute)
        val sdf = SimpleDateFormat("h:mm a", Locale.getDefault())
        return sdf.format(calendar.time)
    }

    // Function to parse the opening hours string into a map of day to opening hours
    fun parseOpeningHours(openingHoursString: String): Map<Int, List<Pair<Int, Int>>> {
        val daysOfWeek = listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")
        val openingHoursMap = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()

        // Split the input string by days
        val daySchedules = openingHoursString.split(";")

        // Parse each day's schedule
        daySchedules.forEach { daySchedule ->
            // Extract day and hours part
            val parts = daySchedule.trim().split(": ")
            if (parts.size == 2) {
                val dayIndex = daysOfWeek.indexOf(parts[0].trim())
                if (dayIndex != -1) {
                    val hours = parts[1].trim()
                    val timeRange = parseTimeRange(hours)
                    if (timeRange != null) {
                        if (!openingHoursMap.containsKey(dayIndex)) {
                            openingHoursMap[dayIndex] = mutableListOf()
                        }
                        openingHoursMap[dayIndex]?.add(timeRange)
                    }
                }
            }
        }

        return openingHoursMap
    }

    // Function to parse a time range string (e.g., "10am-8pm") into start and end times
    fun parseTimeRange(timeRange: String): Pair<Int, Int>? {
        val timeRegex = "(\\d{1,2})(am|pm)-(\\d{1,2})(am|pm)".toRegex()
        val matchResult = timeRegex.find(timeRange)
        if (matchResult != null && matchResult.groupValues.size == 5) {
            val startHour = matchResult.groupValues[1].toInt()
            val startMeridian = matchResult.groupValues[2]
            val endHour = matchResult.groupValues[3].toInt()
            val endMeridian = matchResult.groupValues[4]

            val start24 = convertTo24HourFormat(startHour, startMeridian)
            val end24 = convertTo24HourFormat(endHour, endMeridian)

            return Pair(start24, end24)
        }
        return null
    }

    // Function to convert 12-hour time to 24-hour time
    fun convertTo24HourFormat(hour: Int, meridian: String): Int {
        return if (hour == 12 && meridian.equals("am", ignoreCase = true)) {
            0
        } else if (hour == 12 && meridian.equals("pm", ignoreCase = true)) {
            12
        } else if (meridian.equals("pm", ignoreCase = true)) {
            hour + 12
        } else {
            hour
        }
    }

}