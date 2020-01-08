package com.revolut.currencyconverter.presenters

import com.revolut.currencyconverter.network.model.CurrencyViewerModel
import com.revolut.currencyconverter.utils.Constants

interface ConverterPresenter {
    fun checkValues(base: CurrencyViewerModel?, amount: Float)
    fun updatePositionChange(base:Constants.CurrencyEnum)
}