package com.example.vaccovid19.ui.country

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.vaccovid19.R
import com.example.vaccovid19.base.BaseAdapter
import com.example.vaccovid19.base.BaseViewHolder
import com.example.vaccovid19.data.model.Country
import com.example.vaccovid19.databinding.ItemCountryLayoutBinding

class CountryAdapter(
    private val clickItem: (Country) -> Unit
) :
    BaseAdapter<Country , CountryAdapter.ViewHolder>(Country.getCountryDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemCountryLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding , clickItem)
    }

    class ViewHolder(
        private val binding: ItemCountryLayoutBinding,
        clickItem: (Country) -> Unit
    ) : BaseViewHolder<Country>(binding , clickItem) {

        override fun bindView(item: Country) {
            super.bindView(item)
            binding.apply {
                country = item
                textNumberCase.background = itemView.context.getDrawable(
                    if (item.totalCase >= 10000000) R.drawable.bg_border_30_red else
                        R.drawable.bg_border_30_green
                )
            }
        }
    }
}
