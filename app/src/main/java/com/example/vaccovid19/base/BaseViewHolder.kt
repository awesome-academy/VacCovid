package com.example.vaccovid19.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(
    binding: ViewDataBinding,
    clickItem: (T) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private var item: T? = null

    init {
        itemView.setOnClickListener { item?.let { it1 -> clickItem(it1) } }
    }

    open fun bindView(item: T) {
        this.item = item
    }
}
