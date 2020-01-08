package com.revolut.currencyconverter.di.repository

import com.revolut.currencyconverter.network.model.CurrencyResponseModel
import io.reactivex.Observable

interface CurrencyRepository {
    fun getCurrencyRates(base:String) : Observable<CurrencyResponseModel>
}