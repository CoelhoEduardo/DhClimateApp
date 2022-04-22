package com.example.clima.screen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.clima.MapsActivity
import com.example.clima.R
import com.example.clima.adapters.HomeAdapter
import com.example.clima.mock.Maps.Maps
import com.example.clima.mock.Maps.MapsImage


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val openMap = findViewById<Button>(R.id.btn_open_map)
        val buscas = findViewById<Button>(R.id.btn_buscas)
        val screenshots = findViewById<Button>(R.id.btn_screenshots)
        val favorites = findViewById<Button>(R.id.btn_favorites)
        val profile = findViewById<ImageView>(R.id.profile)

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

        val recycler = findViewById<RecyclerView>(R.id.recycler_maps)
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

        //findNavController().navigate(R.id.action_homeFragment_to_preferencesFragment)
    }

    private fun sendToMap(){
        val intent = Intent(this, MapsActivity::class.java)
        startActivity(intent)
        //findNavController().navigate(R.id.action_homeFragment_to_mapsActivity)
        //findNavController().navigate(R.id.action_homeFragment_to_mapFragment)
    }

    private fun sendToMySearch(){

        //findNavController().navigate(R.id.action_homeFragment_to_mySearchFragment)
    }

    private fun sendToScreenshots(){

        //findNavController().navigate(R.id.action_homeFragment_to_screenshotsFragment)
    }

    private fun sendToFavorites(){

        //findNavController().navigate(R.id.action_homeFragment_to_favoriteFragment)
    }


    }