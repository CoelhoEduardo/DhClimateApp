package com.example.clima

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.clima.Model.Maps.Maps
import com.example.clima.Model.Maps.MapsImage
import com.example.clima.adapter.HomeAdapter

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val openMap = view.findViewById<Button>(R.id.btn_open_map)
        val buscas = view.findViewById<Button>(R.id.btn_buscas)
        val screenshots = view.findViewById<Button>(R.id.btn_screenshots)
        val favorites = view.findViewById<Button>(R.id.btn_favorites)
        val profile = view.findViewById<ImageView>(R.id.profile)

        val listMap = mutableListOf<Maps>(
            MapsImage(
                imageUrl = "https://www.sacbee.com/latest-news/7qnhhk/picture253870323/alternates/FREE_1140/California%20Wildfire%20Map%208%2030.jpg"
            ),
            MapsImage(
                imageUrl = "https://www.sacbee.com/latest-news/7qnhhk/picture253870323/alternates/FREE_1140/California%20Wildfire%20Map%208%2030.jpg"
            ),
            MapsImage(
                imageUrl = "https://www.sacbee.com/latest-news/7qnhhk/picture253870323/alternates/FREE_1140/California%20Wildfire%20Map%208%2030.jpg"
            )
        )

        val recycler = view.findViewById<RecyclerView>(R.id.recycler_maps)
        recycler.adapter = HomeAdapter(listMap)


        openMap.setOnClickListener{
           sendToMap()
        }
        buscas.setOnClickListener{
            sendToMySearch()
        }
        screenshots.setOnClickListener{
            sendToScreenshots()
        }
        favorites.setOnClickListener{
            sendToFavorites()
        }
        profile.setOnClickListener{
            sendToPreferences()
        }


    }

    private fun sendToPreferences() {

        findNavController().navigate(R.id.action_homeFragment_to_preferencesFragment)
    }

    private fun sendToMap(){

        findNavController().navigate(R.id.action_homeFragment_to_mapActivity)
    }

    private fun sendToMySearch(){

        findNavController().navigate(R.id.action_homeFragment_to_mySearchFragment)
    }

    private fun sendToScreenshots(){

        findNavController().navigate(R.id.action_homeFragment_to_screenshotsFragment)
    }

    private fun sendToFavorites(){

        findNavController().navigate(R.id.action_homeFragment_to_favoriteFragment)
    }


}