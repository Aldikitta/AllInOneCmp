package com.cmpisfun.aldikitta

import di.KoinInitializer
import android.app.Application

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        KoinInitializer(applicationContext).init()
    }
}