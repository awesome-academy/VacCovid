package com.sun.vaccovid19.ui.vaccine.dialog

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import com.sun.vaccovid19.data.model.Vaccine
import com.sun.vaccovid19.databinding.DialogVaccineDetailBinding

class VaccineDetaiLDialog(context: Context) : Dialog(context) {

    private val binding: DialogVaccineDetailBinding by lazy {
        DialogVaccineDetailBinding.inflate(layoutInflater)
    }
    var vaccine: Vaccine? = null

    init {
        initDialog()
    }

    override fun show() {
        super.show()
        bindData()
    }

    private fun initDialog() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(binding.root)
        setCancelable(true)
        window?.apply {
            setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT
            )
            setGravity(Gravity.CENTER)
        }
    }

    private fun bindData() {
        binding.vaccine = vaccine
    }
}
