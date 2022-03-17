package com.example.clima.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clima.Model.Maps.Favorite
import com.example.clima.Model.Maps.FavoriteImage
import com.example.clima.R
import com.example.clima.util.extension.load

class FavoriteAdapter (private val item: List<Favorite>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FavoriteViewHolder(inflater.inflate(R.layout.item_favorite, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is FavoriteViewHolder -> holder.bind(item[position] as FavoriteImage)
        }
    }

    override fun getItemCount() = item.size

    class FavoriteViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val image_favorite: ImageView = view.findViewById(R.id.image_favorite)
        private val text_favorite: TextView = view.findViewById(R.id.text_fav)

        fun bind(item: FavoriteImage){
            image_favorite.load(item.favoriteImage)
            text_favorite.text = item.favoriteText
        }
    }

}