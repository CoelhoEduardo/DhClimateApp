package com.example.clima

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clima.Model.Maps.Search
import com.example.clima.adapter.SearchAdapter
import com.example.clima.util.extension.load

class MapFragment : Fragment(R.layout.fragment_map) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val image = view.findViewById<ImageView>(R.id.map_image)
        val imageUrl: String = "https://maplink.global/wp-content/uploads/2021/06/passo-1-fazer-rotas-google-maps.jpg"
        image.load(imageUrl)

        val queimadaButton = view.findViewById<ImageButton>(R.id.queimada_button)
        val queimadaUrl: String = "data:image/png;base64,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"
        queimadaButton.load(queimadaUrl)

        val tempestadeButton = view.findViewById<ImageButton>(R.id.tempestade_button)
        val tempestadeUrl: String = "https://e1.pngegg.com/pngimages/665/905/png-clipart-pokemon-type-symbols-able-white-and-yellow-lightning-logo-thumbnail.png"
        tempestadeButton.load(tempestadeUrl)

        val geadaButton = view.findViewById<ImageButton>(R.id.geada_button)
        val geadaUrl: String = "https://images.saymedia-content.com/.image/t_share/MTc0NDU3ODYxNzg2Mzc5NjI0/best-attacks-in-pokemon-go.jpg"
        geadaButton.load(geadaUrl)


        val radiationButton = view.findViewById<ImageButton>(R.id.radiation_button)
        val radiationUrl: String = "https://p1.hiclipart.com/preview/610/593/301/pokemon-sun-and-moon-rendered-logos-round-orange-logo-png-clipart-thumbnail.jpg"
        radiationButton.load(radiationUrl)


        val iceButton = view.findViewById<ImageButton>(R.id.ice_button)
        val iceUrl: String = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/Pok%C3%A9mon_Ice_Type_Icon.svg/1024px-Pok%C3%A9mon_Ice_Type_Icon.svg.png"
        iceButton.load(iceUrl)


        val vulconButton = view.findViewById<ImageButton>(R.id.vulcon_button)
        val vulconUrl: String = "https://w7.pngwing.com/pngs/900/788/png-transparent-volcano-volcano-s-triangle-silhouette-bit-thumbnail.png"
        vulconButton.load(vulconUrl)


        val home = view.findViewById<ImageView>(R.id.home_button)

        home.setOnClickListener{
            sendToHome()
        }

        val listSearch = MutableList(10){
            Search(


                image = "https://upload.wikimedia.org/wikipedia/commons/8/8c/Cristiano_Ronaldo_2018.jpg",
                local = "Acailandia,MA - Brasil",
                data = "16 MAI 2022"
            )
        }

        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        recycler.adapter = SearchAdapter(listSearch)

    }

    private fun sendToHome() {

        findNavController().navigate(R.id.action_mapFragment_to_homeFragment)

    }

}