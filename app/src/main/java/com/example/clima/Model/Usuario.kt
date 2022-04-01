package com.example.clima.Model

import com.example.clima.Model.Maps.Favorite
import com.example.clima.Model.Screenshot
import com.example.clima.Model.Search

class Usuario(
    val nome: String,
    val email: String,
    val pais: String,
    val senha: String,
){

    val listaBuscas: MutableList<Search> = mutableListOf()
    val listaFavoritos: MutableList<Favorite> = mutableListOf()
    val screenshots: MutableList<Screenshot> = mutableListOf()

}