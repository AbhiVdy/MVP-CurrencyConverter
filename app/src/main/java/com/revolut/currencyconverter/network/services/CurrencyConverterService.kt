package com.revolut.currencyconverter.network.services

import com.revolut.currencyconverter.network.model.CurrencyResponseModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyConverterService {

    @GET("latest")
    fun getUpdatedCurrencyRates(@Query("base") base: String) : Observable<CurrencyResponseModel>
}