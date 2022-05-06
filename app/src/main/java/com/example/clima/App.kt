package com.example.clima

import android.app.Application
import android.content.Context
import com.example.clima.arquitetura.factory.DatabaseFactory
import com.facebook.appevents.AppEventsLogger

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        DatabaseFactory.build(this)
        appContext = applicationContext

        //Pegar eventos do FB
        AppEventsLogger.activateApp(this);
    }

    companion object {
        var appContext: Context? = null
    }
}