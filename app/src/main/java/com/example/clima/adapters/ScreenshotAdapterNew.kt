package com.example.clima.adapters

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.clima.mock.Maps.Maps
import com.example.clima.mock.Maps.MapsImage
import com.example.clima.R
import com.example.clima.mock.Images
import com.example.clima.mock.ImagesBitmap
import com.example.clima.utils.extension.loadRectangle
import java.io.File

class ScreenshotAdapterNew(private val items: List<File>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ScreenshotViewHolder(inflater.inflate(R.layout.item_screenshot, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ScreenshotViewHolder -> holder.bind(items[position])
        }

    }

    override fun getItemCount() = items.size

    class ScreenshotViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val image: ImageView = view.findViewById(R.id.screenshot_image)
        fun bind(item: File) {
            val myBitmap = BitmapFactory.decodeFile(item.getAbsolutePath())
            image.setImageBitmap(myBitmap)
        }
    }

}
