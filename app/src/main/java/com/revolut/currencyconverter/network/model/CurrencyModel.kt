package com.revolut.currencyconverter.network.model

import com.revolut.currencyconverter.utils.Constants

data class CurrencyModel (val symbol: Constants.CurrencyEnum, val rate: Float)