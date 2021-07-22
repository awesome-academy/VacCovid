package com.sun.vaccovid19.utils

import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.sun.vaccovid19.R

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

@BindingAdapter("app:progress")
fun ProgressBar.setProgress(testAmount: Float) {
    this.progress = testAmount.toInt()
}

@BindingAdapter("app:population")
fun TextView.setText(population: Int) {
    this.text = String.format(this.context.getString(R.string.text_population), population)
}

@BindingAdapter("app:trimedName")
fun TextView.setText(name: String) {
    val words = name.split(this.context.getString(R.string.text_dash)).toMutableList()
    val newName = words.map { it.replaceFirstChar { it.uppercase() } }.joinToString(" ")
    this.text = newName
}
