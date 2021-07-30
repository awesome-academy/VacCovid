package com.sun.vaccovid19.ui.home

import androidx.navigation.fragment.findNavController
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.sun.vaccovid19.R
import com.sun.vaccovid19.base.BaseFragment
import com.sun.vaccovid19.data.model.World
import com.sun.vaccovid19.databinding.FragmentHomeLayoutBinding
import com.sun.vaccovid19.utils.hide
import com.sun.vaccovid19.utils.show
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.DecimalFormat

@Suppress("DEPRECATION")
class HomeFragment : BaseFragment<FragmentHomeLayoutBinding>(FragmentHomeLayoutBinding::inflate) {

    private val homeViewModel: HomeViewModel by viewModel()
    private var world: World? = null

    override fun initData() {
        binding.apply {
            homeViewModel.worldData.observe(viewLifecycleOwner, {
                chartWorldData.show()
                worldBinding = it
                world = it
                initPieChart()
                initChartDataset()
                progressHome.hide()
            })
            imageSaved.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeFragmentToVaccineFragment(true)
                findNavController().navigate(action)
            }
        }

    }

    private fun initPieChart() {
        binding.chartWorldData.apply {
            setUsePercentValues(true)
            centerText = DecimalFormat("#,###,###").format(world?.totalCase)
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
                    context?.getString(R.string.text_recovered)
                ),
                PieEntry(
                    deathPercent,
                    context?.getString(R.string.text_deaths)
                ),
                PieEntry(
                    activePercent,
                    context?.getString(R.string.text_active_case)
                )

            )

            val pieDataSet = PieDataSet(entries, "")
            pieDataSet.yValuePosition = PieDataSet.ValuePosition.OUTSIDE_SLICE
            binding.chartWorldData.apply {
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
                    setValueFormatter(PercentFormatter(binding.chartWorldData))
                }

                invalidate()
            }
        }
    }
}
