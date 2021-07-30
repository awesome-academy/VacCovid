package com.sun.vaccovid19.data.model

import androidx.recyclerview.widget.DiffUtil
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "vaccineTbl")
data class Vaccine(

    @ColumnInfo(name = "vaccineId")
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @SerializedName("developerResearcher")
    @ColumnInfo(name = "developerResearcher")
    val developer: String,

    @SerializedName("trimedName")
    @ColumnInfo(name = "trimedName")
    val name: String,

    @SerializedName("category")
    @ColumnInfo(name = "category")
    val category: String,

    @SerializedName("description")
    @ColumnInfo(name = "description")
    val description: String,

    @SerializedName("funder")
    @ColumnInfo(name = "funder")
    val funder: String,

    @SerializedName("lastUpdated")
    @ColumnInfo(name = "lastUpdated")
    val lastUpdate: String,

    @SerializedName("phase")
    @ColumnInfo(name = "phase")
    val phase: String
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
