package com.revolut.currencyconverter.utils.base

import com.revolut.currencyconverter.utils.Constants
import io.reactivex.Observable

interface BasePresenter<V : BaseView> {

    abstract fun getView(): V
    abstract fun setView(view: V)
    fun <T> request(request: Observable<T>, requestId: Int?, base: Constants.CurrencyEnum)
    fun destroy()
}