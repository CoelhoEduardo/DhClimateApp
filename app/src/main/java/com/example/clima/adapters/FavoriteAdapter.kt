package com.example.clima.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.clima.R
import com.example.clima.R.layout.item_favorite
import com.example.clima.arquitetura.response.EventsItem
import com.example.clima.views.viewHolder.getImage

class FavoriteAdapter : RecyclerView.Adapter<FavoriteViewHolder>() {
    private val diffUtil = AsyncListDiffer(this, DIFF_UTIL)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FavoriteViewHolder(inflater.inflate(item_favorite, parent, false))

    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(diffUtil.currentList[position])

    }

    override fun getItemCount() = diffUtil.currentList.size


    fun updateList(eventList: List<EventsItem>) {
        diffUtil.submitList(eventList)
    }


    companion object {
        val DIFF_UTIL = object : DiffUtil.ItemCallback<EventsItem>() {
            override fun areItemsTheSame(oldItem: EventsItem, newItem: EventsItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: EventsItem, newItem: EventsItem): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

}


class FavoriteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val textId: TextView = view.findViewById(R.id.idTextLocal)
    private val dateLocal: TextView = view.findViewById(R.id.dateLocal)
    private val textLocal: TextView = view.findViewById(R.id.textLocal)
    private val linkLocal: TextView = view.findViewById(R.id.link_events)
    private var eventPic: ImageView = view.findViewById(R.id.image)

    fun bind(local: EventsItem) {
        textId.text = local.title
        dateLocal.text = local.geometry.first().date
        linkLocal.text = local.sources.first().url
        textLocal.text = local.categories.first().title
        eventPic.setImageResource(getImage(local.categories.first().title))

    }

}
