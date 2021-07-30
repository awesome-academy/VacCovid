package com.sun.vaccovid19.ui.vaccine

import androidx.navigation.fragment.navArgs
import com.sun.vaccovid19.base.BaseFragment
import com.sun.vaccovid19.data.model.Vaccine
import com.sun.vaccovid19.databinding.FragmentVaccineLayoutBinding
import com.sun.vaccovid19.ui.vaccine.dialog.VaccineDetaiLDialog
import com.sun.vaccovid19.ui.vaccine.dialog.VaccinesDialog
import com.sun.vaccovid19.utils.ApiConstant
import org.koin.androidx.viewmodel.ext.android.viewModel

class VaccineFragment :
    BaseFragment<FragmentVaccineLayoutBinding>(FragmentVaccineLayoutBinding::inflate),
    OnClickVaccineCategoryCallback,
    VaccineDetaiLDialog.OnEventToFragment {

    private val vaccineViewModel: VaccineViewModel by viewModel()
    private var isVaccineSaved = false
    private val args: VaccineFragmentArgs by navArgs()
    private var pairCategory: Pair<String, String>? = null
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
        vaccineViewModel.apply {
            remoteVaccines.observe(viewLifecycleOwner, { vaccineDialog?.receivedData(it, false) })
            localVaccines.observe(viewLifecycleOwner, { vaccineDialog?.receivedData(it, true) })
            isVaccineSaved.observe(viewLifecycleOwner, {
                this@VaccineFragment.isVaccineSaved = it != null
                vaccineDetailDialog?.setSavedVaccineChecked(it != null)

            })
        }
        vaccineDetailDialog?.callBack = this
    }

    override fun onClickRemoteCategory(category: String) {
        vaccineDialog?.show()
        vaccineViewModel.setVaccineRemoteCategory(category)
    }

    override fun onClickLocalCategory(firstCategory: String, secondCategory: String) {
        pairCategory = Pair(firstCategory, secondCategory)
        vaccineDialog?.show()
        pairCategory?.let { vaccineViewModel.setVaccineLocalCategory(it) }
    }

    override fun onClickSave() {
        vaccineDetailDialog?.vaccine?.let {
            if (isVaccineSaved) {
                isVaccineSaved = false
                vaccineViewModel.unSaveVaccine(it.name)
            } else {
                isVaccineSaved = true
                vaccineViewModel.saveVaccine(it)
            }
        }
        if (args.isFromLocal) {
            pairCategory?.let { vaccineViewModel.setVaccineLocalCategory(it) }
        }
        vaccineDetailDialog?.setSavedVaccineChecked(isVaccineSaved)
    }

    private fun bindData() {
        binding.apply {
            apiConstant = ApiConstant
            clickListener = this@VaccineFragment
            isFromLocal = args.isFromLocal
        }
    }

    private fun onClickVaccineItem(vaccine: Vaccine) {
        vaccineDetailDialog?.vaccine = vaccine
        vaccineViewModel.setVaccineName(vaccine.name)
        vaccineDetailDialog?.show()
    }
}
