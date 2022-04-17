package com.example.clima.arquitetura.factory

import com.google.gson.Gson
import com.google.gson.GsonBuilder

object GsonFactory {
    fun build() : Gson = GsonBuilder().create()
}