package com.sun.vaccovid19.ui.vaccine.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import com.sun.vaccovid19.data.model.Vaccine
import com.sun.vaccovid19.databinding.DialogVaccineDetailBinding

class VaccineDetaiLDialog(context: Context) : Dialog(context) {

    private val binding: DialogVaccineDetailBinding by lazy {
        DialogVaccineDetailBinding.inflate(layoutInflater)
    }
    var callBack: OnEventToFragment? = null
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
        binding.imageSave.setOnClickListener {
            callBack?.onClickSave()
        }
    }

    private fun bindData() {
        binding.vaccine = vaccine
    }

    fun setSavedVaccineChecked(isSaved: Boolean) {
        binding.imageSave.setColorFilter(if (isSaved) Color.RED else Color.WHITE)
    }

    interface OnEventToFragment {
        fun onClickSave()
    }
}
