package com.example.vaccovid19.data.model

import com.google.gson.annotations.SerializedName

data class World(
    @SerializedName("TotalCases")
    val totalCase: Int,
    @SerializedName("NewCases")
    val newCases: Int,
    @SerializedName("TotalDeaths")
    val totalDeath: Int,
    @SerializedName("NewDeaths")
    val newDeath:Int,
    @SerializedName("TotalRecovered")
    val totalRecovered: Int,
    @SerializedName("NewRecovered")
    val newRecovered: Int,
    @SerializedName("ActiveCases")
    val activeCase: Int

)
