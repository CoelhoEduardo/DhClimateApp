package com.example.clima.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.clima.R
import com.example.clima.adapters.FavoriteAdapter
import com.example.clima.arquitetura.response.toEventsEntity
import com.example.clima.views.viewModel.MapViewModel

class FavoriteFragment : Fragment(R.layout.fragment_favorite) {

    private val viewModel: MapViewModel by viewModels()
    private var adapterData = FavoriteAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val profile = view.findViewById<ImageView>(R.id.profile)
        val home = view.findViewById<ImageView>(R.id.home)
        val recycler = view.findViewById<RecyclerView>(R.id.favorite_recycler)


        recycler.adapter = adapterData

        saveData()


        profile.setOnClickListener{
            sendToPreferences()
        }

        home.setOnClickListener{
            sendToHome()
        }

    }

    private fun saveData() {
        viewModel.events.observe(viewLifecycleOwner) {
            adapterData.updateDataList(it.events.map { it -> it.toEventsEntity() })
        }
    }



    private fun sendToPreferences() {

        findNavController().navigate(R.id.action_favoriteFragment_to_preferencesFragment)
    }

    private fun sendToHome() {

        findNavController().navigate(R.id.action_favoriteFragment_to_homeFragment)
    }
}

