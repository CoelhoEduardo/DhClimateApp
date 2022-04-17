package com.example.clima.arquitetura.factory

import com.example.clima.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object OkHttpClientFactory {
    fun build() : OkHttpClient = OkHttpClient.Builder().apply {
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            addInterceptor(loggingInterceptor)

        }

        readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
        writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
        connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)

    }.build()

    private const val DEFAULT_TIMEOUT = 60L
}
