package com.example.clima.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.clima.Model.Search
import com.example.clima.R

private const val HEADER = 0
private const val CONTENT = 1
private const val FOOTER = 2


//val mysearch: MutableList<Search> = mutableListOf()

class SearchAdapter() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val search: MutableList<Search> = mutableListOf()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)



        return SearchViewHolder(inflater.inflate(R.layout.item_mysearch, parent, false))

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SearchViewHolder -> holder.bind(search[position])
        }

    }

    fun updateList(lista : List<Search>){
        search.clear()
        search.addAll(lista)
        notifyDataSetChanged()
    }





    override fun getItemCount() = search.size

    /*fun addMySearch(busca: Search) {
        mysearch.add(busca)

    }*/
}

class SearchViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val image: ImageView = view.findViewById(R.id.image)
    private val title: TextView = view.findViewById(R.id.item_search_title)
    private val subtitle: TextView = view.findViewById(R.id.item_search_subtitle)

    fun bind(item: Search) {
        Glide.with(image.context).load(item.image).circleCrop().into(image)
        title.text = item.local
        subtitle.text = item.data


    }



}