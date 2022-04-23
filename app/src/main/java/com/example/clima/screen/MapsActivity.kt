package com.example.clima.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.clima.R
import com.example.clima.adapters.SearchAdapter

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.clima.databinding.ActivityMapsBinding
import com.example.clima.utils.extension.load
import com.example.clima.views.viewHolder.getImage
import com.example.clima.views.viewModel.MapViewModel
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private val adapter = SearchAdapter()
    private val viewModel: MapViewModel by viewModels()
    private val recycler: RecyclerView?
        get() = findViewById(R.id.recycler_maps)
    private val loading: FrameLayout?
        get() = findViewById(R.id.loading)

    val radioButton : RadioGroup?
    get() = findViewById<RadioGroup>(R.id.radio_group)
    private val home : ImageView
    get() = findViewById<ImageView>(R.id.home_button)
    private val queimadaButton : ImageView?
    get() = findViewById<ImageView>(R.id.queimada_button)
    val vulconButton: ImageView?
    get() = findViewById<ImageView>(R.id.vulcon_button)
    val earthquakeButton: ImageView?
    get() = findViewById<ImageView>(R.id.earthquake_button)
    val landslideButton: ImageView?
    get() = findViewById<ImageView>(R.id.landslide_button)
    val iceButton: ImageView?
    get() = findViewById<ImageView>(R.id.ice_button)
    val stormButton: ImageView?
    get() = findViewById<ImageView>(R.id.storm_button)
    val radioOpen: RadioButton
    get() = findViewById<RadioButton>(R.id.open_btn)
    val radioClosed: RadioButton
    get() = findViewById<RadioButton>(R.id.close_button)

    private lateinit var map: GoogleMap
    private lateinit var binding: ActivityMapsBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_map)

        //Iniciando Maps
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        queimadaButton?.setOnClickListener{
            novaRequisicao("wildfires")
        }
        landslideButton?.setOnClickListener{
            novaRequisicao("landslides")

        }
        iceButton?.setOnClickListener{
            novaRequisicao("SeaLakeIce")

        }
        earthquakeButton?.setOnClickListener{
            novaRequisicao("earthquakes")

        }
        stormButton?.setOnClickListener{
            novaRequisicao("severeStorms")

        }
        vulconButton?.setOnClickListener{
            novaRequisicao("volcanoes")

        }

        home.setOnClickListener {
            finish()
        }

        recycler?.adapter = adapter
        viewModel.loadEvents()

        observeData()

        initMap()
    }



    private fun initMap(){
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }
    override fun onMapReady(googleMap: GoogleMap) {

        map = googleMap

        // Add a marker in Sydney and move the camera
        //val sydney = LatLng(-34.0, 151.0)
        //map.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        //map.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        //map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,15f))
    }


    private fun observeData() {
        var local: LatLng = LatLng(-34.0,148.0)
        var title: String = "new"
        viewModel.loading.observe(this) { loading?.isVisible = it }
        viewModel.error.observe(this) {

        }
        viewModel.events.observe(this) {
            adapter.updateList(it.events)
            for(item in it.events){
                local = LatLng(item.geometry.last().coordinates.last(), item.geometry.last().coordinates.first())
                title = item.title
                map.addMarker(MarkerOptions().position(local).title(title))
            }
        }
    }

    private fun sendToHome(){
        /*val navController = findNavController(R.id.mapsActivity)
        navController.navigate()*/
        finish()
    }

    private fun novaRequisicao(string: String){
        viewModel.loadEventsFiltered(string,radioCheck())
        map.clear()
    }

    private fun filtrarEvento(button: ImageView): String {
        if (queimadaButton == button)
            return "wildfires"
        if (earthquakeButton == button)
            return "earthquakes"
        if (iceButton == button)
            return "SeaLakeIce"
        if (stormButton == button)
            return "severeStorms"
        if (landslideButton == button)
            return "landslide"
        if (vulconButton == button)
            return "volcanoes"
        return ""
    }


    private fun radioCheck(): String{
        if(radioOpen.isChecked)
            return "open"
        else
            return "closed"


    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.open_btn ->
                    if (checked) {
                        // Pirates are the best

                    }
                R.id.close_button ->
                    if (checked) {
                        // Ninjas rule

                    }
            }
        }
    }




}