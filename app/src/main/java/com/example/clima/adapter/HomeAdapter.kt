package com.example.clima.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.clima.Model.Maps.Maps
import com.example.clima.Model.Maps.MapsImage
import com.example.clima.R
import com.example.clima.util.extension.load

class HomeAdapter (private val items: List<Maps>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return HomeViewHolder(inflater.inflate(R.layout.item_map, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       when(holder){
           is HomeViewHolder -> holder.bind(items[position] as MapsImage)
       }

    }

    override fun getItemCount() = items.size

    class HomeViewHolder(view:View): RecyclerView.ViewHolder(view){
        private val image: ImageView = view.findViewById(R.id.image)
        fun bind(item: MapsImage) {
            image.load(item.imageUrl)
        }
    }


}