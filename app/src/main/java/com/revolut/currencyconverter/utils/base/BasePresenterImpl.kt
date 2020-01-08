package com.revolut.currencyconverter.utils.base

import com.revolut.currencyconverter.utils.Constants
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

abstract class BasePresenterImpl<V : BaseView> : BasePresenter<V> {

    private val compositeDisposable = CompositeDisposable()

    var requestId: Int? = null
    private lateinit var view: V
    private var showLoading = true
    private var currentResponse: Any? = null
    private var viewStopped = false
    private var currentBase: String = ""

    override fun getView(): V {
        return view
    }

    override fun setView(view: V) {
        this.view = view
    }

    private fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun destroy() {
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }

    override fun <T> request(request: Observable<T>, requestId: Int?, base: Constants.CurrencyEnum) {
        this.requestId = requestId
        addDisposable(processData(request, base))
    }

    private fun <T> processData(data: Observable<T>, base: Constants.CurrencyEnum): Disposable {
        currentBase = base.toString()
        return data
            .doOnSubscribe { disposable ->
                if (showLoading)
                    view.showLoading()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

            .subscribe(
                { value -> currentResponse = value
                    getView().dismissLoading()
                    onSuccess(currentResponse)
                },
                { onError ->
                    getView().dismissLoading()
                    onError()
                    showLoading = true
                })
            //.repeatUntil { viewStopped || base.toString() != currentBase }
            //.delay(3, TimeUnit.SECONDS)
    }

    private fun onError() {
        viewStopped = true
        view.showDefaultErrorMessage()
    }

    protected abstract fun <T> onSuccess(response: T?)
}