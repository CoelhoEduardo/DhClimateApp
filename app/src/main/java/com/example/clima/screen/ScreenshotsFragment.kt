package com.example.clima.screen

import android.accounts.AccountManager.get
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clima.R
import com.example.clima.mock.Maps.Maps
import com.example.clima.mock.Maps.MapsImage
import com.example.clima.adapters.ScreenshotAdapter
import com.getbase.floatingactionbutton.FloatingActionButton
import com.getbase.floatingactionbutton.FloatingActionsMenu



class ScreenshotsFragment : Fragment(R.layout.fragment_screenshots) {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listMap = mutableListOf<Maps>(
            MapsImage(
                imageUrl = "https://www.sacbee.com/latest-news/7qnhhk/picture253870323/alternates/FREE_1140/California%20Wildfire%20Map%208%2030.jpg"
            ),
            MapsImage(
                imageUrl = "https://www.sacbee.com/latest-news/7qnhhk/picture253870323/alternates/FREE_1140/California%20Wildfire%20Map%208%2030.jpg"
            ),
            MapsImage(
                imageUrl = "https://www.sacbee.com/latest-news/7qnhhk/picture253870323/alternates/FREE_1140/California%20Wildfire%20Map%208%2030.jpg"
            ),
            MapsImage(
                imageUrl = "https://www.sacbee.com/latest-news/7qnhhk/picture253870323/alternates/FREE_1140/California%20Wildfire%20Map%208%2030.jpg"
            ),
            MapsImage(
                imageUrl = "https://www.sacbee.com/latest-news/7qnhhk/picture253870323/alternates/FREE_1140/California%20Wildfire%20Map%208%2030.jpg"
            ),
            MapsImage(
                imageUrl = "https://www.sacbee.com/latest-news/7qnhhk/picture253870323/alternates/FREE_1140/California%20Wildfire%20Map%208%2030.jpg"
            ),
            MapsImage(
                imageUrl = "https://www.sacbee.com/latest-news/7qnhhk/picture253870323/alternates/FREE_1140/California%20Wildfire%20Map%208%2030.jpg"
            ),
            MapsImage(
                imageUrl = "https://www.sacbee.com/latest-news/7qnhhk/picture253870323/alternates/FREE_1140/California%20Wildfire%20Map%208%2030.jpg"
            ),
            MapsImage(
                imageUrl = "https://www.sacbee.com/latest-news/7qnhhk/picture253870323/alternates/FREE_1140/California%20Wildfire%20Map%208%2030.jpg"
            ),
            MapsImage(
                imageUrl = "https://www.sacbee.com/latest-news/7qnhhk/picture253870323/alternates/FREE_1140/California%20Wildfire%20Map%208%2030.jpg"
            ),

        )

        val home = view.findViewById<ImageView>(R.id.home)

        val recycler = view.findViewById<RecyclerView>(R.id.screenshot_recycler)
        recycler.layoutManager = GridLayoutManager(context, 3)
        recycler.adapter = ScreenshotAdapter(listMap)
        val fab = view.findViewById<FloatingActionsMenu>(R.id.fab)
        val fab1 = view.findViewById<FloatingActionButton>(R.id.fab1)
        val fab2 = view.findViewById<FloatingActionButton>(R.id.fab2)


        home.setOnClickListener{
            sendToHome()
        }

        fab1?.setOnClickListener {
            sendToHome()
        }
        fab2?.setOnClickListener {
            sendToMaps()
        }

    }

    private fun sendToHome() {

        findNavController().navigate(R.id.action_screenshotsFragment_to_homeFragment)
    }

    private fun sendToMaps() {
    val intent = Intent(activity, MapsActivity::class.java)
        startActivity(intent)
        //findNavController().navigate(R.id.action_screenshotsFragment_to_mapsActivity)
    }
}