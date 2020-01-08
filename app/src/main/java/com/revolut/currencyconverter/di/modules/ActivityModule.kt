package com.revolut.currencyconverter.di.modules

import com.revolut.currencyconverter.views.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule {

    @ContributesAndroidInjector
    fun mainActivity(): MainActivity
}