package com.sun.vaccovid19.utils

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sun.vaccovid19.R
import com.sun.vaccovid19.base.SubmitData
import java.text.DecimalFormat

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
    this.text = String.format(
        this.context.getString(R.string.text_population),
        DecimalFormat("#,###,###").format(population)
    )
}

@BindingAdapter("app:trimedName")
fun TextView.setText(name: String) {
    val words = name.split(this.context.getString(R.string.text_dash)).toMutableList()
    val newName = words.map { it.replaceFirstChar { it.uppercase() } }.joinToString(" ")
    this.text = newName
}

@BindingAdapter("app:data")
fun <T> RecyclerView.setData(data: List<T>?) {
    (adapter as SubmitData<T>).submitData(data)
}

@BindingAdapter("app:imageUrl")
fun ImageView.setImage(url: String) {
    Glide.with(context)
        .load(url)
        .error(R.drawable.ic_launcher_background)
        .placeholder(R.drawable.ic_launcher_background)
        .into(this)
}

@BindingAdapter("app:formatNumber")
fun TextView.setTextFormat(number: Int?) {
    this.text = DecimalFormat("#,###,###").format(number)
}

@BindingAdapter("app:formatNumberIncrease")
fun TextView.setTextIncrease(number: Int?) {
    this.text = "+" + DecimalFormat("#,###,###").format(number)
}
