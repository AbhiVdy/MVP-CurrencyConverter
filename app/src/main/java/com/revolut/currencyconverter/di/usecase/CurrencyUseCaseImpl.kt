package com.revolut.currencyconverter.di.usecase

import com.revolut.currencyconverter.di.datastores.CurrencyDataStoreImpl
import com.revolut.currencyconverter.network.model.CurrencyResponseModel
import io.reactivex.Observable
import javax.inject.Inject

class CurrencyUseCaseImpl @Inject constructor(private val currencyRepo: CurrencyDataStoreImpl) : CurrencyUseCase {
    override fun currencyConvert(base: String): Observable<CurrencyResponseModel> {
        return currencyRepo.getCurrencyList(base)
    }
}