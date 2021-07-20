package com.sun.vaccovid19.ui.vaccine

import com.sun.vaccovid19.base.BaseFragment
import com.sun.vaccovid19.data.model.Vaccine
import com.sun.vaccovid19.databinding.FragmentVaccineBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class VaccineFragment: BaseFragment<FragmentVaccineBinding>(FragmentVaccineBinding::inflate) {

    private val vaccineViewModel: VaccineViewModel by viewModel()

    override fun initData() {
        vaccineViewModel.vaccines.observe(viewLifecycleOwner , {observeVaccines(it)})
    }

    private fun observeVaccines(vaccines: List<Vaccine>) {

    }
}
