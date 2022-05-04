package com.example.clima

import android.app.Application
import android.content.Context
import com.facebook.appevents.AppEventsLogger

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext

        //Pegar eventos do FB
        AppEventsLogger.activateApp(this);
    }

    companion object {
        var appContext: Context? = null
    }
}