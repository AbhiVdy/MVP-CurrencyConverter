package com.revolut.currencyconverter.di.usecase

import com.revolut.currencyconverter.network.model.CurrencyResponseModel
import io.reactivex.Observable

interface CurrencyUseCase {
    fun currencyConvert(base:String) : Observable<CurrencyResponseModel>
}