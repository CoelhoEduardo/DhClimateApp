package com.example.clima.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.clima.R
import com.example.clima.arquitetura.response.EventsItem
import com.example.clima.mock.Pins
import com.example.clima.views.viewHolder.SearchViewHolder


class SearchAdapter : RecyclerView.Adapter<SearchViewHolder>() {
    private val diffUtil = AsyncListDiffer(this, DIFF_UTIL)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return SearchViewHolder(inflater.inflate(R.layout.item_search, parent, false))
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(diffUtil.currentList[position])
    }

    override fun getItemCount() = diffUtil.currentList.size

    fun updateList(eventList: List<EventsItem<Any?>>) {
        diffUtil.submitList(eventList)
    }

    companion object {
        val DIFF_UTIL = object : DiffUtil.ItemCallback<EventsItem<Any?>>() {
            override fun areItemsTheSame(oldItem: EventsItem<Any?>, newItem: EventsItem<Any?>): Boolean {
                return oldItem.categories.first().title == newItem.categories.first().title
            }
            override fun areContentsTheSame(oldItem: EventsItem<Any?>, newItem: EventsItem<Any?>): Boolean {
                return oldItem == newItem
            }
        }
    }

}
