package com.revolut.currencyconverter.di.repository

import com.revolut.currencyconverter.di.datastores.CurrencyDataStoreImpl
import com.revolut.currencyconverter.network.model.CurrencyResponseModel
import io.reactivex.Observable
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(private val currencyRepo: CurrencyDataStoreImpl) : CurrencyRepository {
    override fun getCurrencyRates(base: String): Observable<CurrencyResponseModel> {
        return  currencyRepo.getCurrencyList(base)
    }

}