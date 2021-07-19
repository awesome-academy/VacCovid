package com.sun.vaccovid19.base

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class BaseAdapter<T , VH: BaseViewHolder<T>>(
    diffUtil: DiffUtil.ItemCallback<T>
) : ListAdapter<T, VH>(diffUtil){

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bindView(getItem(position))
    }

}
