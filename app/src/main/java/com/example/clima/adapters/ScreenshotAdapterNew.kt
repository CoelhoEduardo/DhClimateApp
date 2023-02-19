package com.example.clima.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.clima.R
import com.example.clima.mock.ImagesBitmap
import com.example.clima.views.viewHolder.ScreenshotViewHolder
import com.example.clima.views.viewHolder.SearchViewHolder
import java.io.File

class ScreenshotAdapterNew(private val clickListener: (ImagesBitmap) -> Unit) : RecyclerView.Adapter<ScreenshotViewHolder>() {

    private val diffUtil = AsyncListDiffer(this, DIFF_UTIL)

    private val dataList = mutableListOf<ImagesBitmap>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScreenshotViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        dataList.addAll(diffUtil.currentList)
        return ScreenshotViewHolder(inflater.inflate(R.layout.item_screenshot, parent, false)) {
            clickListener(dataList[it])
        }
    }

    override fun onBindViewHolder(holder: ScreenshotViewHolder, position: Int) {

        holder.bind(diffUtil.currentList[position])

    }

    fun updateList(items: List<ImagesBitmap>) {
        diffUtil.submitList(items)
        dataList.clear()
        dataList.addAll(items)


    }

    override fun getItemCount() = diffUtil.currentList.size

    companion object {
        val DIFF_UTIL = object : DiffUtil.ItemCallback<ImagesBitmap>() {
            override fun areItemsTheSame(oldItem: ImagesBitmap, newItem: ImagesBitmap): Boolean {
                return oldItem.imageUrl == newItem.imageUrl
            }

            override fun areContentsTheSame(oldItem: ImagesBitmap, newItem: ImagesBitmap): Boolean {
                return oldItem.imageUrl == newItem.imageUrl
            }
        }
    }
}


