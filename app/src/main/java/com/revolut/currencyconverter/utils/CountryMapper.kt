package com.revolut.currencyconverter.utils

import android.content.Context
import com.revolut.currencyconverter.R
import com.revolut.currencyconverter.network.model.CurrencyModel
import com.revolut.currencyconverter.network.model.CurrencyViewerModel

open class CountryMapper {
    companion object {

        fun getFormattedData(model: CurrencyModel, context: Context) : CurrencyViewerModel{
            return when(model.symbol){
                Constants.CurrencyEnum.EUR -> CurrencyViewerModel(flag = R.drawable.ic_flag_european_union, currencyCode = model.symbol, currencyName = context.getString(R.string.name_EUR), value = model.rate)
                Constants.CurrencyEnum.AUD -> CurrencyViewerModel(flag = R.drawable.ic_flag_australia, currencyCode = model.symbol, currencyName = context.getString(R.string.name_AUD), value = model.rate)
                Constants.CurrencyEnum.BGN -> CurrencyViewerModel(flag = R.drawable.ic_flag_bulgaria, currencyCode = model.symbol, currencyName = context.getString(R.string.name_BGN), value = model.rate)
                Constants.CurrencyEnum.BRL -> CurrencyViewerModel(flag = R.drawable.ic_flag_brazil, currencyCode = model.symbol, currencyName = context.getString(R.string.name_BRL), value = model.rate)
                Constants.CurrencyEnum.CAD -> CurrencyViewerModel(flag = R.drawable.ic_flag_canada, currencyCode = model.symbol, currencyName = context.getString(R.string.name_CAD), value = model.rate)
                Constants.CurrencyEnum.CHF -> CurrencyViewerModel(flag = R.drawable.ic_flag_switzerland, currencyCode = model.symbol, currencyName = context.getString(R.string.name_CHF), value = model.rate)
                Constants.CurrencyEnum.CNY -> CurrencyViewerModel(flag = R.drawable.ic_flag_china, currencyCode = model.symbol, currencyName = context.getString(R.string.name_CNY), value = model.rate)
                Constants.CurrencyEnum.CZK -> CurrencyViewerModel(flag = R.drawable.ic_flag_czech_republic, currencyCode = model.symbol, currencyName = context.getString(R.string.name_CZK), value = model.rate)
                Constants.CurrencyEnum.DKK -> CurrencyViewerModel(flag = R.drawable.ic_flag_denmark, currencyCode = model.symbol, currencyName = context.getString(R.string.name_DKK), value = model.rate)
                Constants.CurrencyEnum.GBP -> CurrencyViewerModel(flag = R.drawable.ic_flag_united_kingdom, currencyCode = model.symbol, currencyName = context.getString(R.string.name_GBP), value = model.rate)
                Constants.CurrencyEnum.HKD -> CurrencyViewerModel(flag = R.drawable.ic_flag_hong_kong, currencyCode = model.symbol, currencyName = context.getString(R.string.name_HKD), value = model.rate)
                Constants.CurrencyEnum.HRK -> CurrencyViewerModel(flag = R.drawable.ic_flag_croatia, currencyCode = model.symbol, currencyName = context.getString(R.string.name_HRK), value = model.rate)
                Constants.CurrencyEnum.HUF -> CurrencyViewerModel(flag = R.drawable.ic_flag_hungary, currencyCode = model.symbol, currencyName = context.getString(R.string.name_HUF), value = model.rate)
                Constants.CurrencyEnum.IDR -> CurrencyViewerModel(flag = R.drawable.ic_flag_indonesia, currencyCode = model.symbol, currencyName = context.getString(R.string.name_IDR), value = model.rate)
                Constants.CurrencyEnum.ILS -> CurrencyViewerModel(flag = R.drawable.ic_flag_israel, currencyCode = model.symbol, currencyName = context.getString(R.string.name_ILS), value = model.rate)
                Constants.CurrencyEnum.INR -> CurrencyViewerModel(flag = R.drawable.ic_flag_india, currencyCode = model.symbol, currencyName = context.getString(R.string.name_INR), value = model.rate)
                Constants.CurrencyEnum.ISK -> CurrencyViewerModel(flag = R.drawable.ic_flag_iceland, currencyCode = model.symbol, currencyName = context.getString(R.string.name_ISK), value = model.rate)
                Constants.CurrencyEnum.JPY -> CurrencyViewerModel(flag = R.drawable.ic_flag_japan, currencyCode = model.symbol, currencyName = context.getString(R.string.name_JPY), value = model.rate)
                Constants.CurrencyEnum.KRW -> CurrencyViewerModel(flag = R.drawable.ic_flag_south_korea, currencyCode = model.symbol, currencyName = context.getString(R.string.name_KRW), value = model.rate)
                Constants.CurrencyEnum.MXN -> CurrencyViewerModel(flag = R.drawable.ic_flag_mexico, currencyCode = model.symbol, currencyName = context.getString(R.string.name_MXN), value = model.rate)
                Constants.CurrencyEnum.MYR -> CurrencyViewerModel(flag = R.drawable.ic_flag_malaysia, currencyCode = model.symbol, currencyName = context.getString(R.string.name_MYR), value = model.rate)
                Constants.CurrencyEnum.NOK -> CurrencyViewerModel(flag = R.drawable.ic_flag_norway, currencyCode = model.symbol, currencyName = context.getString(R.string.name_NOK), value = model.rate)
                Constants.CurrencyEnum.NZD -> CurrencyViewerModel(flag = R.drawable.ic_flag_new_zealand, currencyCode = model.symbol, currencyName = context.getString(R.string.name_NZD), value = model.rate)
                Constants.CurrencyEnum.PHP -> CurrencyViewerModel(flag = R.drawable.ic_flag_philippines, currencyCode = model.symbol, currencyName = context.getString(R.string.name_PHP), value = model.rate)
                Constants.CurrencyEnum.PLN -> CurrencyViewerModel(flag = R.drawable.ic_flag_portugal, currencyCode = model.symbol, currencyName = context.getString(R.string.name_PLN), value = model.rate)
                Constants.CurrencyEnum.RON -> CurrencyViewerModel(flag = R.drawable.ic_flag_romania, currencyCode = model.symbol, currencyName = context.getString(R.string.name_RON), value = model.rate)
                Constants.CurrencyEnum.RUB -> CurrencyViewerModel(flag = R.drawable.ic_flag_russia, currencyCode = model.symbol, currencyName = context.getString(R.string.name_RUB), value = model.rate)
                Constants.CurrencyEnum.SEK -> CurrencyViewerModel(flag = R.drawable.ic_flag_sweden, currencyCode = model.symbol, currencyName = context.getString(R.string.name_SEK), value = model.rate)
                Constants.CurrencyEnum.SGD -> CurrencyViewerModel(flag = R.drawable.ic_flag_singapore, currencyCode = model.symbol, currencyName = context.getString(R.string.name_SGD), value = model.rate)
                Constants.CurrencyEnum.THB -> CurrencyViewerModel(flag = R.drawable.ic_flag_thailand, currencyCode = model.symbol, currencyName = context.getString(R.string.name_THB), value = model.rate)
                Constants.CurrencyEnum.TRY -> CurrencyViewerModel(flag = R.drawable.ic_flag_turkey, currencyCode = model.symbol, currencyName = context.getString(R.string.name_TRY), value = model.rate)
                Constants.CurrencyEnum.USD -> CurrencyViewerModel(flag = R.drawable.ic_flag_usa, currencyCode = model.symbol, currencyName = context.getString(R.string.name_USD), value = model.rate)
                Constants.CurrencyEnum.ZAR -> CurrencyViewerModel(flag = R.drawable.ic_flag_south_africa, currencyCode = model.symbol, currencyName = context.getString(R.string.name_ZAR), value = model.rate)
            }
        }



    }
}