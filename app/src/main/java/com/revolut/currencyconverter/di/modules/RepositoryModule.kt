package com.revolut.currencyconverter.di.modules

import com.revolut.currencyconverter.di.datastores.CurrencyDataStoreImpl
import com.revolut.currencyconverter.network.services.CurrencyConverterService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideCurrencyDataStore(currencyService: CurrencyConverterService) : CurrencyDataStoreImpl {
        return CurrencyDataStoreImpl(currencyService)
    }
}