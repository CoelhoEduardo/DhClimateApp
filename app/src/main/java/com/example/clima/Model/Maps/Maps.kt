package com.example.clima.Model.Maps


sealed class Maps {
}

class MapsImage(
    val imageUrl: String
): Maps()

sealed class Favorite (
)


class FavoriteImage(
    val favoriteImage: String,
    val favoriteText: String
): Favorite()