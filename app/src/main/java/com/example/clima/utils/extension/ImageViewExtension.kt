package com.example.clima.utils.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(url: String) {
    Glide.with(this.context).load(url).circleCrop().into(this)

}

fun ImageView.loadRectangle(url: String) {
    Glide.with(this.context).load(url).fitCenter().into(this)
}
