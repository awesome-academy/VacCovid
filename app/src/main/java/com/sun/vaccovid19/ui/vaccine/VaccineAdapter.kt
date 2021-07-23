package com.sun.vaccovid19.ui.vaccine

import android.view.LayoutInflater
import android.view.ViewGroup
import com.sun.vaccovid19.base.BaseAdapter
import com.sun.vaccovid19.base.BaseViewHolder
import com.sun.vaccovid19.data.model.Vaccine
import com.sun.vaccovid19.databinding.ItemVaccineLayoutBinding

class VaccineAdapter(private val onItemClick: (Vaccine) -> Unit) :
    BaseAdapter<Vaccine, VaccineAdapter.ViewHolder>(Vaccine.getVaccineDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemVaccineLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        onItemClick
    )

    class ViewHolder(
        private val binding: ItemVaccineLayoutBinding,
        onItemClick: (Vaccine) -> Unit
    ) : BaseViewHolder<Vaccine>(binding, onItemClick) {

        override fun bindView(item: Vaccine) {
            super.bindView(item)
            binding.vaccine = item
        }
    }
}
