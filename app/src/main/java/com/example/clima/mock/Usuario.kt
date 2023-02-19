package com.example.clima.mock

import com.example.clima.mock.Maps.Favorite

class Usuario(
    val nome: String,
    val email: String,
    val pais: String,
    val senha: String,
) {

    val listaBuscas: MutableList<Search> = mutableListOf()
    val listaFavoritos: MutableList<Favorite> = mutableListOf()
    val screenshots: MutableList<Screenshot> = mutableListOf()

}
