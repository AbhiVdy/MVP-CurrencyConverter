package com.revolut.currencyconverter.di.datastores

import com.revolut.currencyconverter.network.model.CurrencyResponseModel
import com.revolut.currencyconverter.network.services.CurrencyConverterService
import io.reactivex.Observable
import javax.inject.Inject

class CurrencyDataStoreImpl @Inject constructor(private val service: CurrencyConverterService) : CurrencyDataStore {

    override fun getCurrencyList(base: String): Observable<CurrencyResponseModel> {
        return service.getUpdatedCurrencyRates(base)
    }
}