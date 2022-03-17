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

class ScreenshotAdapter (private val items: List<Maps>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ScreenshotViewHolder(inflater.inflate(R.layout.item_screenshot, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ScreenshotViewHolder -> holder.bind(items[position] as MapsImage)
        }

    }

    override fun getItemCount() = items.size

    class ScreenshotViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val image: ImageView = view.findViewById(R.id.screenshot_image)
        fun bind(item: MapsImage) {
            image.load(item.imageUrl)
        }
    }


}