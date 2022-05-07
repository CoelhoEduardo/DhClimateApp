package com.example.clima.mock


import java.io.File


sealed class Images {
}

class ImagesBitmap(
    val imageUrl: String
) : Images()

