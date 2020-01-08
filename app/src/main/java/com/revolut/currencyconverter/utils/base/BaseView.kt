package com.revolut.currencyconverter.utils.base

interface BaseView {
    fun showLoading()
    fun dismissLoading()
    fun showDefaultErrorMessage()
}