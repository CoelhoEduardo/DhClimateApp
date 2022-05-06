package com.example.clima.screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clima.R
import com.example.clima.adapters.ScreenshotAdapter
import com.example.clima.mock.Maps.Maps
import com.example.clima.mock.Maps.MapsImage
import com.getbase.floatingactionbutton.FloatingActionButton
import com.getbase.floatingactionbutton.FloatingActionsMenu

class ScreenshotActivity : AppCompatActivity() {


    private val home
        get() = findViewById<ImageView>(R.id.home)


    private val recycler
        get() = findViewById<RecyclerView>(R.id.screenshot_recycler)
    private val fab
        get() = findViewById<FloatingActionsMenu>(R.id.fab)
    private val fab1
        get() = findViewById<FloatingActionButton>(R.id.fab1)
    private val fab2
        get() = findViewById<FloatingActionButton>(R.id.fab2)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screenshot)

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
                imageUrl = ""
            ),

            )


        recycler.layoutManager = GridLayoutManager(this, 3)
        recycler.adapter = ScreenshotAdapter(listMap)

        home?.setOnClickListener {
            sendToHome()
        }

        fab1?.setOnClickListener {
            sendToSearch()
        }
        fab2?.setOnClickListener {

            sendToMaps()
        }

    }


    private fun sendToSearch() {
        val intent = Intent(this, LocalBaseActivity::class.java)
        startActivity(intent)

        val frame: FrameLayout = findViewById(R.id.frame_total)
        // Pega o FragmentManager
        // Pega o FragmentManager
        val fm = supportFragmentManager
// Substitui um Fragment
        val ft = fm.beginTransaction()
        frame.visibility = View.VISIBLE
//        ft.replace(R.id.frame_total, FavoriteFragment())
        ft.commit()
        fab?.collapse()
    }


    private fun sendToHome() {

        //findNavController().navigate(R.id.action_screenshotsFragment_to_homeFragment)
    }


    private fun sendToMaps() {
        val intent = Intent(this, MapsActivity::class.java)
        startActivity(intent)
        //findNavController().navigate(R.id.action_screenshotsFragment_to_mapsActivity)
    }
}
