package com.example.clima.views.viewHolder

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clima.R
import com.example.clima.arquitetura.response.EventsItem
import com.example.clima.mock.ImagesBitmap
import java.io.File

class ScreenshotViewHolder(view: View, clickAtPosition: (Int) -> (Unit)) :
    RecyclerView.ViewHolder(view) {
    init {
        itemView.setOnClickListener {
            clickAtPosition(adapterPosition)
        }
    }

    private val dataList = mutableListOf<String>()
    private val image: ImageView? = view.findViewById(R.id.screenshot_image)



    fun bind(file: ImagesBitmap) {
        var folder = File(file.imageUrl)
        val myBitmap = BitmapFactory.decodeFile(folder.getAbsolutePath())
        image?.setImageBitmap(myBitmap)
        dataList.add(file.imageUrl)

    }

}

