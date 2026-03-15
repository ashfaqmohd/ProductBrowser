package com.example.productbrowser

import android.app.Application
import com.example.productbrowser.di.initKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}