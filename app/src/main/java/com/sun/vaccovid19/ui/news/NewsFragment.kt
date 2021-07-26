package com.sun.vaccovid19.ui.news

import android.graphics.Color
import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.app.AppCompatActivity
import com.sun.vaccovid19.R
import com.sun.vaccovid19.base.BaseFragment
import com.sun.vaccovid19.databinding.FragmentNewsLayoutBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsFragment : BaseFragment<FragmentNewsLayoutBinding>(FragmentNewsLayoutBinding::inflate) {

    private val newsViewModel: NewsViewModel by viewModel()

    override fun initData() {
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarNews)
        setHasOptionsMenu(true)
        binding.toolbarNews.overflowIcon?.setTint(Color.WHITE)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.news_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}
