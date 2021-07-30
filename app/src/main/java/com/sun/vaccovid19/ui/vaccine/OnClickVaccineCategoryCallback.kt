package com.sun.vaccovid19.ui.vaccine

interface OnClickVaccineCategoryCallback {

    fun onClickRemoteCategory(category: String)
    fun onClickLocalCategory(firstCategory: String, secondCategory: String)
}
