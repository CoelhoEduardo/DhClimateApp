package com.example.clima.mock


import java.io.File


sealed class Images {
}

class ImagesBitmap(
    val imageUrl: File
) : Images()

sealed class Favorite(
)


class FavoriteImages(
    val favoriteImage: String,
    val favoriteText: String
) : Favorite()
