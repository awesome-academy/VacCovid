package com.example.vaccovid19.data.model

import com.google.gson.annotations.SerializedName

data class Country(
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
)
