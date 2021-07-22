package com.sun.vaccovid19.ui.vaccine

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import com.sun.vaccovid19.data.model.Vaccine
import com.sun.vaccovid19.databinding.DialogVaccineLayoutBinding
import com.sun.vaccovid19.utils.hide

class VaccinesDialog(context: Context) : Dialog(context) {

    private val binding: DialogVaccineLayoutBinding by lazy {
        DialogVaccineLayoutBinding.inflate(layoutInflater)
    }

    init {
        initDialog()
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

        binding.textClose.setOnClickListener { dismiss() }
    }

    fun receivedData(vaccines: List<Vaccine>) {
        if (vaccines.isNotEmpty()) {
            binding.progressVaccine.hide()
        }
    }
}
