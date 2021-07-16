package com.example.vaccovid19.data.model

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("id")
    val id: String,
    @SerializedName("Country")
    val country: String,
    @SerializedName("Continent")
    val continent: String,
    @SerializedName("Test_Percentage")
    val testPercent: Float,
    @SerializedName("TotalCases")
    val totalCase: Int,
    @SerializedName("TotalDeaths")
    val totalDeath: Int,
    @SerializedName("TotalRecovered")
    val totalRecovered: Int,
    @SerializedName("ActiveCases")
    val activeCase: Int
) {
    companion object {
        fun getCountryDiffUtil() = object : DiffUtil.ItemCallback<Country>() {
            override fun areItemsTheSame(oldItem: Country, newItem: Country) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Country, newItem: Country) = oldItem == newItem

        }
    }
}
