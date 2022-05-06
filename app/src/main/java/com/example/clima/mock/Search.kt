package com.example.clima.mock

import android.os.Parcelable

import kotlinx.parcelize.Parcelize

@Parcelize
class Search(
    val image: String,
    val local: String,
    val data: String
) : Parcelable
