package com.revolut.currencyconverter.presenters

import com.revolut.currencyconverter.di.usecase.CurrencyUseCaseImpl
import com.revolut.currencyconverter.network.model.CurrencyModel
import com.revolut.currencyconverter.network.model.CurrencyResponseModel
import com.revolut.currencyconverter.network.model.CurrencyViewerModel
import com.revolut.currencyconverter.utils.Constants
import com.revolut.currencyconverter.utils.CountryMapper
import com.revolut.currencyconverter.utils.base.BasePresenterImpl
import com.revolut.currencyconverter.views.fragments.ConverterView
import javax.inject.Inject

private const val CURRENCY_VALUES = 100

class ConverterPresenterImpl @Inject constructor(private val ratesUsecase: CurrencyUseCaseImpl): BasePresenterImpl<ConverterView>(), ConverterPresenter{

    private var currentBaseVal: Constants.CurrencyEnum? = null
    private var defaultAmount = 1F

    override fun checkValues(model: CurrencyViewerModel?, amount: Float) {
        model?.let { modelObj ->
            if(currentBaseVal != modelObj.currencyCode){
                request(ratesUsecase.currencyConvert(modelObj.currencyCode.toString()), CURRENCY_VALUES, modelObj.currencyCode)
                currentBaseVal = modelObj.currencyCode
            }else{
              if(defaultAmount != amount){
                  defaultAmount = amount
                  getView().onAmountChange(amount)
              }
            }
        } ?:run {
            request(ratesUsecase.currencyConvert(Constants.CurrencyEnum.EUR.toString()), CURRENCY_VALUES, Constants.CurrencyEnum.EUR)
        }
    }

    override fun updatePositionChange(base: Constants.CurrencyEnum) {
        request(ratesUsecase.currencyConvert(base.toString()), CURRENCY_VALUES, base)
    }


    override fun <T> onSuccess(response: T?) {
        when(requestId) {
            CURRENCY_VALUES -> validateResponse(response as CurrencyResponseModel)
        }
    }

    private fun validateResponse(response: CurrencyResponseModel) {
        val validateResponse = getFormatedValues(response)
        getView().onDataReceived(validateResponse)
    }

    private fun getFormatedValues(response: CurrencyResponseModel) : ArrayList<CurrencyModel> {
        val rates = ArrayList<CurrencyModel>()
        rates.add(CurrencyModel(response.base, defaultAmount))
        rates.addAll(response.rates.map { CurrencyModel(it.key, it.value) })
        return rates
    }
}