package com.sun.vaccovid19.ui.news

import android.graphics.Color
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.sun.vaccovid19.R
import com.sun.vaccovid19.base.BaseFragment
import com.sun.vaccovid19.data.model.News
import com.sun.vaccovid19.databinding.FragmentNewsLayoutBinding
import com.sun.vaccovid19.utils.ApiConstant
import com.sun.vaccovid19.utils.AppConstant
import com.sun.vaccovid19.utils.hide
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsFragment : BaseFragment<FragmentNewsLayoutBinding>(FragmentNewsLayoutBinding::inflate) {

    private val newsViewModel: NewsViewModel by viewModel()
    private var adapter: NewsAdapter? = NewsAdapter(this::onClickNewsItem)
    private var page = ""
    private var type = ""

    override fun initData() {
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarNews)
        setHasOptionsMenu(true)
        binding.toolbarNews.overflowIcon?.setTint(Color.WHITE)
        setPageNumberText(AppConstant.FIRST_PAGE)
        setNewsType(ApiConstant.COVID_NEWS_PARAM, getString(R.string.text_one))
        bindData()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.news_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.vaccineNews -> setNewsType(
                ApiConstant.VACCINE_NEWS_PARAM,
                getString(R.string.text_one)
            )
            R.id.healthNews -> setNewsType(
                ApiConstant.HEALTH_NEWS_PARAM,
                getString(R.string.text_one)
            )
            R.id.covidNews -> setNewsType(
                ApiConstant.COVID_NEWS_PARAM,
                getString(R.string.text_one)
            )
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        adapter = null
        super.onDestroy()
    }

    private fun bindData() {
        binding.apply {
            recyclerNews.adapter = adapter
            newsViewModel = this@NewsFragment.newsViewModel
            lifecycleOwner = viewLifecycleOwner
            this@NewsFragment.newsViewModel.news.observe(viewLifecycleOwner, {
                if (it.isNotEmpty()) {
                    progressNews.hide()
                }
            })
        }
    }

    private fun setNewsType(type: String, page: String) {
        this.type = type
        this.page = page
        newsViewModel.setNewsTypeAndPage(this.type, this.page)
    }

    private fun setPageNumberText(page: Int) {
        binding.textPageNumber.text = String.format(getString(R.string.text_page_number), page)
    }

    private fun onClickNewsItem(news: News) {

    }
}
