package com.revolut.currencyconverter.di.datastores

import com.revolut.currencyconverter.network.model.CurrencyResponseModel
import io.reactivex.Observable

interface CurrencyDataStore {
    fun getCurrencyList(base:String) : Observable<CurrencyResponseModel>
}