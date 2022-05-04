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
import com.example.clima.arquitetura.local.entity.EventsEntity
import com.example.clima.arquitetura.response.EventsItem

class FavoriteAdapter : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {
    private val diffUtil = AsyncListDiffer(this, DIFF_UTIL)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FavoriteViewHolder(inflater.inflate(R.layout.item_favorite, parent, false))
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(diffUtil.currentList[position])
    }

    override fun getItemCount() = diffUtil.currentList.size

    fun updateDataList(eventList: List<EventsEntity>) {
        diffUtil.submitList(eventList)
    }

    companion object {
        val DIFF_UTIL = object : DiffUtil.ItemCallback<EventsEntity>() {
            override fun areItemsTheSame(oldItem: EventsEntity, newItem: EventsEntity): Boolean {
                return oldItem == newItem
            }
            override fun areContentsTheSame(oldItem: EventsEntity, newItem: EventsEntity): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

    class FavoriteViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val imageFavorite: ImageView = view.findViewById(R.id.image_favorite)
        private val textFavorite: TextView = view.findViewById(R.id.text_fav)
        private val date: TextView = view.findViewById(R.id.date_events)
        private val link: TextView = view.findViewById(R.id.link_events)
        private val eventsData: TextView = view.findViewById(R.id.data_events)

        fun bind(events: EventsEntity){
            textFavorite.text = events.title
            date.text = events.geometryItem.toString()
            link.text = events.sourcesItem.toString()
            eventsData.text = events.categoriesItem.toString()
        }
    }

}