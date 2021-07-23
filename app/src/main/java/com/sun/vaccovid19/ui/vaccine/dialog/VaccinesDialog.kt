package com.sun.vaccovid19.ui.vaccine.dialog

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.LifecycleOwner
import com.sun.vaccovid19.data.model.Vaccine
import com.sun.vaccovid19.databinding.DialogVaccineLayoutBinding
import com.sun.vaccovid19.ui.vaccine.VaccineAdapter
import com.sun.vaccovid19.ui.vaccine.VaccineViewModel
import com.sun.vaccovid19.utils.AppConstant
import com.sun.vaccovid19.utils.hide
import java.util.*
import kotlin.concurrent.schedule

const val DELAY_TEXT_CHANGE = 500L

class VaccinesDialog(
    context: Context,
    private val vaccineViewModel: VaccineViewModel,
    private val viewLifecycleOwner: LifecycleOwner,
    private val clickVaccineItem: (Vaccine) -> Unit
) : Dialog(context),
    SearchView.OnQueryTextListener {

    private val binding: DialogVaccineLayoutBinding by lazy {
        DialogVaccineLayoutBinding.inflate(layoutInflater)
    }
    private val adapter = VaccineAdapter(this::onClickVaccine)
    private val vaccines = mutableListOf<Vaccine>()

    init {
        initDialog()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        query?.let { filterList(it) }
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        Timer().schedule(DELAY_TEXT_CHANGE) {
            newText?.let { filterList(it) }
        }
        return false
    }

    override fun dismiss() {
        binding.searchVaccine.apply {
            setQuery(AppConstant.BLANK, false)
            clearFocus()
        }
        super.dismiss()
    }

    private fun initDialog() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(binding.root)
        setCancelable(true)
        window?.apply {
            setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT
            )
            setGravity(Gravity.CENTER)
        }

        initViews()
        binding.textClose.setOnClickListener { dismiss() }
    }

    private fun initViews() {
        binding.apply {
            recyclerVaccine.adapter = adapter
            searchVaccine.setOnQueryTextListener(this@VaccinesDialog)
            vaccineViewModel = this@VaccinesDialog.vaccineViewModel
            lifecycleOwner = viewLifecycleOwner
        }
    }

    private fun onClickVaccine(vaccine: Vaccine) {
        clickVaccineItem(vaccine)
    }

    private fun filterList(query: String) {
        val vaccinesFilter = vaccines.filter { it.name.contains(query, ignoreCase = true) }
        adapter.submitList(vaccinesFilter)
    }

    fun receivedData(vaccines: List<Vaccine>) {
        if (vaccines.isNotEmpty()) {
            binding.progressVaccine.hide()
            this.vaccines.addAll(vaccines)
        }
    }
}
