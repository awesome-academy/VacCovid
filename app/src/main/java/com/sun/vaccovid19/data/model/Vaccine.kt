package com.sun.vaccovid19.data.model

import com.google.gson.annotations.SerializedName

data class Vaccine(
    @SerializedName("developerResearcher")
    val developer: String,
    @SerializedName("trimedName")
    val name: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("funder")
    val funder: String,
    @SerializedName("lastUpdated")
    val lastUpdate: String
)
