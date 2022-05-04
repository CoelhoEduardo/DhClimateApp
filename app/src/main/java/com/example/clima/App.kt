package com.example.clima

import android.app.Application
import com.facebook.appevents.AppEventsLogger

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        //Pegar eventos do FB
        AppEventsLogger.activateApp(this);
    }
}