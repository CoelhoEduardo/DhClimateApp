package com.example.clima

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toolbar
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val openMap = view.findViewById<Button>(R.id.btn_open_map)
        val buscas = view.findViewById<Button>(R.id.btn_buscas)
        val screenshots = view.findViewById<Button>(R.id.btn_screenshots)
        val favorites = view.findViewById<Button>(R.id.btn_favorites)
        val profile = view.findViewById<ImageView>(R.id.profile)



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

        findNavController().navigate(R.id.action_homeFragment_to_mapFragment)
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