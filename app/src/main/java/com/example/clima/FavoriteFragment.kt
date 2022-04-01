package com.example.clima

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.clima.Model.Maps.Favorite
import com.example.clima.Model.Maps.FavoriteImage
import com.example.clima.adapter.FavoriteAdapter

class FavoriteFragment : Fragment(R.layout.fragment_favorite) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

        val profile = view.findViewById<ImageView>(R.id.profile)
        val home = view.findViewById<ImageView>(R.id.home)
        val recycler = view.findViewById<RecyclerView>(R.id.favorite_recycler)
        recycler.adapter = FavoriteAdapter(listFavorite)

        profile.setOnClickListener{
            sendToPreferences()
        }

        home.setOnClickListener{
            sendToHome()
        }

    }

    private fun sendToPreferences() {

        findNavController().navigate(R.id.action_favoriteFragment_to_preferencesFragment)
    }

    private fun sendToHome() {

        findNavController().navigate(R.id.action_favoriteFragment_to_homeFragment)
    }
}
