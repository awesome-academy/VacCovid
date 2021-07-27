package com.sun.vaccovid19.ui.news

import android.view.LayoutInflater
import android.view.ViewGroup
import com.sun.vaccovid19.base.BaseAdapter
import com.sun.vaccovid19.base.BaseViewHolder
import com.sun.vaccovid19.data.model.News
import com.sun.vaccovid19.databinding.ItemNewsLayoutBinding

class NewsAdapter(private val onClickItem: (News) -> Unit) :
    BaseAdapter<News, NewsAdapter.ViewHolder>(News.getNewsDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemNewsLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        onClickItem
    )

    class ViewHolder(
        private val binding: ItemNewsLayoutBinding,
        onClickItem: (News) -> Unit
    ) : BaseViewHolder<News>(binding, onClickItem) {

        override fun bindView(item: News) {
            super.bindView(item)
            binding.news = item
        }
    }
}
