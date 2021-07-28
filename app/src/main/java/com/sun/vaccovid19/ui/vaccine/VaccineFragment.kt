package com.sun.vaccovid19.ui.vaccine

import com.sun.vaccovid19.base.BaseFragment
import com.sun.vaccovid19.data.model.Vaccine
import com.sun.vaccovid19.databinding.FragmentVaccineLayoutBinding
import com.sun.vaccovid19.ui.vaccine.dialog.VaccineDetaiLDialog
import com.sun.vaccovid19.ui.vaccine.dialog.VaccinesDialog
import com.sun.vaccovid19.utils.ApiConstant
import org.koin.androidx.viewmodel.ext.android.viewModel

class VaccineFragment :
    BaseFragment<FragmentVaccineLayoutBinding>(FragmentVaccineLayoutBinding::inflate),
    OnClickVaccineCategoryCallback {

    private val vaccineViewModel: VaccineViewModel by viewModel()
    private val vaccineDialog: VaccinesDialog? by lazy {
        context?.let {
            VaccinesDialog(it, vaccineViewModel, viewLifecycleOwner, this::onClickVaccineItem)
        }
    }
    private val vaccineDetailDialog: VaccineDetaiLDialog? by lazy {
        context?.let { VaccineDetaiLDialog(it) }
    }

    override fun initData() {
        bindData()
        vaccineViewModel.remoteVaccines.observe(viewLifecycleOwner, { vaccineDialog?.receivedData(it) })
    }

    override fun onClickCategory(category: String) {
        vaccineDialog?.show()
        vaccineViewModel.setVaccineCategory(category)
    }

    private fun bindData() {
        binding.apply {
            apiConstant = ApiConstant
            clickListener = this@VaccineFragment
        }
    }

    private fun onClickVaccineItem(vaccine: Vaccine) {
        vaccineDetailDialog?.vaccine = vaccine
        vaccineDetailDialog?.show()
    }
}
