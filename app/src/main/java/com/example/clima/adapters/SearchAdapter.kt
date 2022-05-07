package com.example.clima.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.clima.R
import com.example.clima.arquitetura.response.EventsItem
import com.example.clima.views.viewHolder.SearchViewHolder


class SearchAdapter(private val clickListener: (EventsItem) -> Unit) :
    RecyclerView.Adapter<SearchViewHolder>() {
    private val diffUtil = AsyncListDiffer(this, DIFF_UTIL)

    private val dataList = mutableListOf<EventsItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        dataList.addAll(diffUtil.currentList)
        return SearchViewHolder(inflater.inflate(R.layout.item_search, parent, false)) {
            clickListener(dataList[it])
            //clickListenerLink(dataList[it])

        }
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {

        holder.bind(diffUtil.currentList[position])

    }

    override fun getItemCount() = diffUtil.currentList.size

    fun updateList(eventList: List<EventsItem>) {
        diffUtil.submitList(eventList)
        dataList.clear()
        dataList.addAll(eventList)


    }

    companion object {
        val DIFF_UTIL = object : DiffUtil.ItemCallback<EventsItem>() {
            override fun areItemsTheSame(oldItem: EventsItem, newItem: EventsItem): Boolean {
                return oldItem.categories.first().title == newItem.categories.first().title
            }

            override fun areContentsTheSame(oldItem: EventsItem, newItem: EventsItem): Boolean {
                return oldItem == newItem
            }
        }
    }

}
