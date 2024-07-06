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
