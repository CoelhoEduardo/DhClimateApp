package com.example.clima.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.clima.mock.Search
import com.example.clima.R

//private val adapterSearch = SearchAdapter()

class MySearchAdapter(private val search: List<Search>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return ContactViewHolder(inflater.inflate(R.layout.item_mysearch, parent, false))

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ContactViewHolder -> holder.bind(search[position])
        }

    }

    override fun getItemCount() = search.size
}

class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val image: ImageView = view.findViewById(R.id.image)
    private val title: TextView = view.findViewById(R.id.item_search_title)
    private val subtitle: TextView = view.findViewById(R.id.item_search_subtitle)

    fun bind(item: Search) {
        Glide.with(image.context).load(item.image).circleCrop().into(image)
        title.text = item.local
        subtitle.text = item.data


    }
}