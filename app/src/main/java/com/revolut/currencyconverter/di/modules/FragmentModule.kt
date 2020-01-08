package com.revolut.currencyconverter.di.modules

import com.revolut.currencyconverter.utils.base.BaseFragment
import com.revolut.currencyconverter.views.fragments.ConverterFragment
import com.revolut.currencyconverter.views.fragments.RatesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentModule {

    @ContributesAndroidInjector
    fun ratesFragmemt() : RatesFragment

    @ContributesAndroidInjector
    fun converterFragment() : ConverterFragment

    @ContributesAndroidInjector
    fun baseFragment() : BaseFragment
}