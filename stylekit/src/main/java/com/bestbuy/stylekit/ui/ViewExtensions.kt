package com.bestbuy.stylekit.ui

import android.view.View
import android.widget.ProgressBar

/**
 * @Author: Anil Gudigar
 * @Date: 05/07/24
 */
fun ProgressBar.hide() {
    visibility = View.GONE
}

fun ProgressBar.show() {
    visibility = View.VISIBLE
}

fun Any?.toDoubleOrZero(): Double {
    return when (this) {
        is Number -> this.toDouble()
        is String -> this.toDoubleOrNull() ?: 0.0
        else -> 0.0
    }

}
fun Any?.toStringOrEmpty(): String {
    return this?.toString() ?: ""
}
