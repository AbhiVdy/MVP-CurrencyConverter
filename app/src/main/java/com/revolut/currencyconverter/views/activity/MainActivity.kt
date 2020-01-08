package com.revolut.currencyconverter.views.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.revolut.currencyconverter.R
import com.revolut.currencyconverter.utils.TabsAdapter
import com.revolut.currencyconverter.views.fragments.ConverterFragment
import com.revolut.currencyconverter.views.fragments.RatesFragment
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        val tabsAdapter = TabsAdapter(supportFragmentManager)
        tabsAdapter.addFragment(RatesFragment(), getString(R.string.home_tab_title_converter))
        tabsAdapter.addFragment(ConverterFragment(), getString(R.string.home_tab_title_allRates))
        viewpager.adapter = tabsAdapter
        tabLayout.setupWithViewPager(viewpager)
    }
}
