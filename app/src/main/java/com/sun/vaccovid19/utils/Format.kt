package com.sun.vaccovid19.utils

import java.text.DecimalFormat

object NumberFormat {

    fun getNumberFormat(number: Int?) =
        DecimalFormat("#,###,###").format(number)

    fun getNumberFormatIncrease(number: Int?) =
        "+" + DecimalFormat("#,###,###").format(number)
}
