package com.revolut.currencyconverter.network.model

import com.google.gson.annotations.SerializedName
import com.revolut.currencyconverter.utils.Constants

data class CurrencyResponseModel(
    @SerializedName("base")
    val base: Constants.CurrencyEnum,
    @SerializedName("date")
    val date: String,
    @SerializedName("rates")
    val rates: Map<Constants.CurrencyEnum, Float>
)