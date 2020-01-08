package com.revolut.currencyconverter.views.fragments

import com.revolut.currencyconverter.network.model.CurrencyModel
import com.revolut.currencyconverter.utils.base.BaseView
import kotlin.collections.ArrayList

interface ConverterView : BaseView {
    fun onDataReceived(currencyModel: ArrayList<CurrencyModel>)
    fun onUpdateData()
    fun onAmountChange(amount: Float)
}