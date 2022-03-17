package com.example.clima

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
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

        val recycler = view.findViewById<RecyclerView>(R.id.favorite_recycler)
        recycler.adapter = FavoriteAdapter(listFavorite)

    }
}
