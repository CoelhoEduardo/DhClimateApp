package com.example.clima.Model

import android.os.Parcel
import android.os.Parcelable

import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
class Search(
    val image: String,
    val local: String,
    val data: String
) : Parcelable {
    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }


}

