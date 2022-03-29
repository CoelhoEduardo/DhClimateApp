package com.example.clima.Model.Maps

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
class Search(
    val image: String,
    val local: String,
    val data: String
) : Parcelable

