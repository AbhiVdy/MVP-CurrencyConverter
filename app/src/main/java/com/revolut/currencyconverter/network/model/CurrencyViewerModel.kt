package com.revolut.currencyconverter.network.model

import com.revolut.currencyconverter.utils.Constants

data class CurrencyViewerModel(
    val flag: Int,
    val currencyCode: Constants.CurrencyEnum,
    val currencyName: String,
    var value: Float
)