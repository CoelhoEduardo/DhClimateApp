package com.example.clima.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.clima.R
import com.example.clima.adapters.FavoriteAdapter
import com.example.clima.mock.Maps.Favorite
import com.example.clima.mock.Maps.FavoriteImage

class SearchActivity : AppCompatActivity() {
    val profile : ImageView
    get() = findViewById<ImageView>(R.id.profile)
    val back : ImageView
        get() = findViewById<ImageView>(R.id.home)
    val recycler : RecyclerView
    get() = findViewById<RecyclerView>(R.id.favorite_recycler)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val listFavorite = mutableListOf<Favorite>(
            FavoriteImage(
                "https://tm.ibxk.com.br/2021/12/20/20095730932072.jpg?ims=1200x675",
                "QUEIMADAS"

            ),
            FavoriteImage(
                "https://tm.ibxk.com.br/2021/12/20/20095730932072.jpg?ims=1200x675",
                "QUEIMADAS"
            ),
            FavoriteImage(
                "https://tm.ibxk.com.br/2021/12/20/20095730932072.jpg?ims=1200x675",
                "QUEIMADAS"
            ),
        )


        recycler.adapter = FavoriteAdapter(listFavorite)

        profile.setOnClickListener{
            //sendToPreferences()
        }

        back.setOnClickListener{
            //sendToHome()
        }
    }





}