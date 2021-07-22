package com.sun.vaccovid19.data.model

import androidx.recyclerview.widget.DiffUtil
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
) {
    companion object {

        fun getVaccineDiffUtil() = object : DiffUtil.ItemCallback<Vaccine>() {
            override fun areItemsTheSame(oldItem: Vaccine, newItem: Vaccine) =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: Vaccine, newItem: Vaccine) =
                oldItem == newItem

        }
    }
}
