package com.example.vaccovid19.ui.home

import com.example.vaccovid19.R
import com.example.vaccovid19.base.BaseFragment
import com.example.vaccovid19.data.model.World
import com.example.vaccovid19.databinding.FragmentHomeLayoutBinding
import com.example.vaccovid19.utils.NumberFormat
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import org.koin.androidx.viewmodel.ext.android.viewModel

@Suppress("DEPRECATION")
class HomeFragment : BaseFragment<FragmentHomeLayoutBinding>(FragmentHomeLayoutBinding::inflate) {

    private val homeViewModel: HomeViewModel by viewModel()
    private var world: World? = null

    override fun initData() {
        bindData()
        homeViewModel.worldData.observe(viewLifecycleOwner, {
            binding?.world = it
            world = it
            initPieChart()
            initChartDataset()
        })
    }

    override fun initViews() {
    }

    private fun bindData() {
        binding?.numberFormat = NumberFormat
    }

    private fun initPieChart() {
        binding?.chartWorldData?.apply {
            setUsePercentValues(true)
            centerText = NumberFormat.getNumberFormat(world?.totalCase)
            setCenterTextSize(resources.getDimension(R.dimen.sp_5))
            setCenterTextColor(resources.getColor(R.color.color_green))
            isDrawHoleEnabled = true
            setTransparentCircleColor(resources.getColor(android.R.color.white))
            description.isEnabled = false
            setDrawSliceText(false)
            setDrawEntryLabels(false)
            legend.apply {
                verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
                horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER
                orientation = Legend.LegendOrientation.HORIZONTAL
                textSize = resources.getDimension(R.dimen.sp_4)
                setDrawInside(false)
                isEnabled = true
            }
        }
    }

    private fun initChartDataset() {
        world?.let {
            val recoveredPercent = (it.totalRecovered.toFloat() / it.totalCase.toFloat())
            val deathPercent = (it.totalDeath.toFloat() / it.totalCase.toFloat())
            val activePercent = (it.activeCase.toFloat() / it.totalCase.toFloat())
            val entries = listOf(
                PieEntry(
                    recoveredPercent,
                    context?.getString(R.string.text_total_recovered)
                ),
                PieEntry(
                    deathPercent,
                    context?.getString(R.string.text_total_deaths)
                ),
                PieEntry(
                    activePercent,
                    context?.getString(R.string.text_total_active_case)
                )

            )

            val pieDataSet = PieDataSet(entries, "")
            pieDataSet.yValuePosition = PieDataSet.ValuePosition.OUTSIDE_SLICE
            binding?.chartWorldData?.apply {
                resources.apply {
                    pieDataSet.colors = listOf(
                        getColor(R.color.color_royal_blue),
                        getColor(R.color.color_red_ribbon),
                        getColor(R.color.color_razzle_dazzle_rose),
                    )
                }
                data = PieData(pieDataSet).apply {
                    setDrawValues(true)
                    setValueTextColor(resources.getColor(android.R.color.black))
                    setValueTextSize(resources.getDimension(R.dimen.sp_4))
                    setValueFormatter(PercentFormatter(binding?.chartWorldData))
                }

                invalidate()
            }
        }
    }
}
