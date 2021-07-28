package com.sun.vaccovid19.ui.news

import android.graphics.Color
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.sun.vaccovid19.R
import com.sun.vaccovid19.base.BaseFragment
import com.sun.vaccovid19.data.model.News
import com.sun.vaccovid19.databinding.FragmentNewsLayoutBinding
import com.sun.vaccovid19.utils.ApiConstant
import com.sun.vaccovid19.utils.AppConstant
import com.sun.vaccovid19.utils.hide
import com.sun.vaccovid19.utils.show
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsFragment : BaseFragment<FragmentNewsLayoutBinding>(FragmentNewsLayoutBinding::inflate) {

    private val newsViewModel: NewsViewModel by viewModel()
    private var adapter: NewsAdapter? = NewsAdapter(this::onClickNewsItem)
    private var page = AppConstant.FIRST_PAGE
    private var type = ""

    override fun initData() {
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarNews)
        setHasOptionsMenu(true)
        binding.toolbarNews.overflowIcon?.setTint(Color.WHITE)
        setPageNumberText(page)
        setNewsTypeAndPage(ApiConstant.COVID_NEWS_PARAM, false)
        bindData()
        newsViewModel.pageStatus.observe(viewLifecycleOwner, Observer {
            if (it && page < AppConstant.END_PAGE) {
                page++
                setNewsTypeAndPage(type, true)
            } else if (page > AppConstant.FIRST_PAGE) {
                page--
                setNewsTypeAndPage(type, true)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.news_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.vaccineNews -> setNewsTypeAndPage(
                ApiConstant.VACCINE_NEWS_PARAM,
                false
            )
            R.id.healthNews -> setNewsTypeAndPage(
                ApiConstant.HEALTH_NEWS_PARAM,
                false
            )
            R.id.covidNews -> setNewsTypeAndPage(
                ApiConstant.COVID_NEWS_PARAM,
                false
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

    private fun setNewsTypeAndPage(type: String, isNextPage: Boolean) {
        this.type = type
        if (!isNextPage) {
            page = AppConstant.FIRST_PAGE
        }
        binding.apply {
            progressNews.show()
            if (page > AppConstant.FIRST_PAGE) imageLeft.show() else imageLeft.hide()
            if (page < AppConstant.END_PAGE) imageRight.show() else imageRight.hide()
        }
        setPageNumberText(page)
        newsViewModel.setNewsTypeAndPage(this.type, page.toString())
    }

    private fun setPageNumberText(page: Int) {
        binding.textPageNumber.text = String.format(getString(R.string.text_page_number), page)
    }

    private fun onClickNewsItem(news: News) {
        binding.webNews.apply {
            show()
            settings.javaScriptEnabled = true
            settings.setSupportZoom(true)
            canGoBack()
            loadUrl(news.link)
        }
    }
}
