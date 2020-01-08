package com.revolut.currencyconverter.di.modules

import android.content.Context
import com.revolut.currencyconverter.ConverterApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ActivityModule::class, FragmentModule::class, AndroidSupportInjectionModule::class, NetworkModule::class, RepositoryModule::class])
interface AppComponent {

    fun inject(application: ConverterApp)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: ConverterApp): Builder

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }
}