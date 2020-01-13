package com.revolut.currencyconverter.views.fragments

import androidx.recyclerview.widget.LinearLayoutManager
import com.revolut.currencyconverter.R
import com.revolut.currencyconverter.network.model.CurrencyModel
import com.revolut.currencyconverter.network.model.CurrencyViewerModel
import com.revolut.currencyconverter.presenters.ConverterPresenterImpl
import com.revolut.currencyconverter.utils.CountryMapper
import com.revolut.currencyconverter.utils.base.BaseFragment
import com.revolut.currencyconverter.views.adapters.CurrencyAdapter
import kotlinx.android.synthetic.main.fragment_converter.*
import javax.inject.Inject

class ConverterFragment : BaseFragment(), ConverterView {

    override fun onAmountChange(amount: Float) {
        currencyAdapter?.updateDefaultAmount(amount)
    }

    @Inject
    lateinit var converterPresenter: ConverterPresenterImpl
    private var currencyViewerList: ArrayList<CurrencyViewerModel>? = null
    private var currencyAdapter: CurrencyAdapter? = null

    override fun init() {
        converterPresenter.setView(this)
        converterPresenter.checkValues(null, 1F)
    }

    override fun setContentLayout(): Int {
        return R.layout.fragment_converter
    }

    private fun setupAdapter(currencyList: ArrayList<CurrencyViewerModel>) {
        currencyAdapter = CurrencyAdapter()
        currencyAdapter?.setList(currencyList)
        currencyAdapter?.onPositionChangeListener {
            converterPresenter.updatePositionChange(it.currencyCode)
        }
        currencyAdapter?.onValueChangeListener { model, amount ->
            converterPresenter.checkValues(model, amount)
        }
        rvCurrency.layoutManager = LinearLayoutManager(context)
        rvCurrency.adapter = currencyAdapter
    }

    private fun updateCurrencyValues(currencyList: ArrayList<CurrencyViewerModel>) {
        if(!rvCurrency.isComputingLayout){
            currencyAdapter?.setList(currencyList)
        }
    }

    override fun onUpdateData() {

    }

    override fun onDataReceived(currencyModel: ArrayList<CurrencyModel>) {
        currencyViewerList = formatInputList(currencyModel)
        currencyAdapter?.let {
            updateCurrencyValues(currencyViewerList!!)
        } ?: kotlin.run {
            setupAdapter(currencyViewerList!!)
        }
    }

    private fun formatInputList(currencyModel: ArrayList<CurrencyModel>): ArrayList<CurrencyViewerModel> {
        val viewerList = ArrayList<CurrencyViewerModel>()
        currencyModel.forEach {
            viewerList.add(CountryMapper.getFormattedData(it, context!!))
        }
        return viewerList
    }
}