package com.bestbuy.core.data

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

/**
 * @Author: Anil Gudigar
 * @Date: 13/07/24
 */
class DoubleDeserializer : JsonDeserializer<Double> {
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Double {
        return try {
            val value = json.asString
            if (value.isEmpty()) 0.0 else value.toDouble()
        } catch (e: NumberFormatException) {
            0.0 // or any other default value
        }
    }
}