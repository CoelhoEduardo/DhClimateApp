package com.example.clima.screen

import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.media.MediaActionSound
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.format.DateFormat
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.FileProvider
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentContainerView
import androidx.recyclerview.widget.RecyclerView
import com.example.clima.R
import com.example.clima.adapters.SearchAdapter
import com.example.clima.databinding.ActivityMapsBinding
import com.example.clima.views.viewModel.MapViewModel
import com.getbase.floatingactionbutton.FloatingActionButton
import com.getbase.floatingactionbutton.FloatingActionsMenu
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMap.SnapshotReadyCallback
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import saveImage
import java.io.*
import java.util.*


class MapsActivity() : AppCompatActivity(), OnMapReadyCallback {

    private val adapter = SearchAdapter() {
        val local =
            LatLng(it.geometry.last().coordinates.last(), it.geometry.last().coordinates.first())
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(local, 10f))
    }

    private val viewModel: MapViewModel by viewModels()
    private val recycler: RecyclerView?
        get() = findViewById(R.id.recycler_maps)

    private val loading: FrameLayout?
        get() = findViewById(R.id.loading)

    /*val layout_map: FrameLayout
    get() = findViewById(R.id.frame_layout)*/

    val layout_map: FragmentContainerView
        get() = findViewById(R.id.map)

    val radioButton: RadioGroup?
        get() = findViewById<RadioGroup>(R.id.radio_group)
    private val switch: ImageView
        get() = findViewById<ImageView>(R.id.switch_button)
    private val queimadaButton: ImageView?
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
    val fab: FloatingActionsMenu?
        get() = findViewById<FloatingActionsMenu>(R.id.fab)
    val fab1: FloatingActionButton?
        get() = findViewById<FloatingActionButton>(R.id.fab1)
    val fab2: FloatingActionButton?
        get() = findViewById<FloatingActionButton>(R.id.fab2)
    val screenshot: ImageButton?
        get() = findViewById<ImageButton>(R.id.camera_button)


    private lateinit var map: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    private var switchposition = 0


    private lateinit var view: View


    lateinit var photoPath: String
    val REQUEST_TAKE_PHOTO = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_map)

        //Iniciando Maps
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)




        fab1?.setOnClickListener {
            sendToSearch()
        }
        fab2?.setOnClickListener {

            sendToScreenshots()
        }

        queimadaButton?.setOnClickListener {
            novaRequisicao("wildfires")
        }
        landslideButton?.setOnClickListener {
            novaRequisicao("landslides")

        }
        iceButton?.setOnClickListener {
            novaRequisicao("SeaLakeIce")

        }
        earthquakeButton?.setOnClickListener {
            novaRequisicao("earthquakes")

        }
        stormButton?.setOnClickListener {
            novaRequisicao("severeStorms")

        }
        vulconButton?.setOnClickListener {
            novaRequisicao("volcanoes")

        }
        screenshot?.setOnClickListener {
            //val callback = SnapshotReadyCallback()
            //takeScreenShot()
            //screenshotButton(view)
            //takePicture()
            //map.setMapType(GoogleMap.MAP_TYPE_HYBRID)
            //map.snapshot(callback)
            //button_listener()
            //captureScreen()
            //takeScreenshot2()
            /*val callback: SnapshotReadyCallback = object : SnapshotReadyCallback {
                var bitmap: Bitmap? = null
                override fun onSnapshotReady(snapshot: Bitmap?) {
                    bitmap = snapshot
                    try {
                        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).parentFile.mkdir()
                        val out = FileOutputStream(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES))

                        bitmap?.compress(Bitmap.CompressFormat.PNG, 100, out)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
            map.snapshot(callback)*/
            map.snapshot(::getScreen)
        }
        switch.setOnClickListener {

            verifySwitchMap()

        }



        recycler?.adapter = adapter
        viewModel.loadEvents()

        observeData()

        initMap()
    }

    private fun verifySwitchMap() {
        if (switchposition == 0) {
            map.setMapType(GoogleMap.MAP_TYPE_HYBRID)
            switchposition = 1
        } else {
            map.setMapType(GoogleMap.MAP_TYPE_NORMAL)
            switchposition = 0
        }
    }

    private fun screenshotButton(view: View) {
        var view2 = view
        view2 = window.decorView.rootView


    }

    /*public void ScreenshotButton(View view){
        var view1 = getWindow().getDecorView().getRootView();
        view1.setDrawingCacheEnabled(true);
        var bitmap = Bitmap.createBitmap(view1.getDrawingCache());
        view1.setDrawingCacheEnabled(false);

        var filePath = Environment.getExternalStorageDirectory()+"/Download/"+ Calendar.getInstance().getTime().toString()+".jpg";
        var fileScreenshot = File(filePath);
        File(filePath)
        var fileOutputStream = null
        public void ScreenshotButton(View view){
            View view1 = getWindow().getDecorView().getRootView();
            view1.setDrawingCacheEnabled(true);
            Bitmap bitmap = Bitmap.createBitmap(view1.getDrawingCache());
            view1.setDrawingCacheEnabled(false);

            String filePath = Environment.getExternalStorageDirectory()+"/Download/"+ Calendar.getInstance().getTime().toString()+".jpg";
            File fileScreenshot = new File(filePath);
            FileOutputStream fileOutputStream = null
*/


    /*private fun takePicture(){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        if(intent.resolveActivity(packageManager) != null){

            var photoFile: File? = null
            try {
                photoFile = createImageFile()
            }catch (e : IOException){
                if(photoFile != null){
                    var photoUri = FileProvider.getUriForFile(
                        this,
                        "com.example.clima.screen.android.fileprovider",
                        photoFile
                    )
                    intent.putExtra(MediaStore.EXTRA_OUTPUT,photoUri)
                    startActivityForResult(intent,REQUEST_TAKE_PHOTO)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_TAKE_PHOTO && resultCode == Activity.RESULT_OK){
          *//*  picture.rotation = 90f
            picture.setImageURI(Uri.parse(photoPath))*//*

        }
    }

    private fun createImageFile(): File? {

        val fileName = "MyPicture"
        val storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val image = File.createTempFile(
            fileName,
            ".jpg",
            storageDir
        )
            photoPath = image.absolutePath
        return image

    }*/

    private fun initMap() {
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        //view = mapFragment.requireView()

    }

    override fun onMapReady(googleMap: GoogleMap) {

        map = googleMap
        /*map.isMyLocationEnabled = true
        map.setOnMyLocationButtonClickListener(this)
        map.setOnMyLocationClickListener(this)*/

        // Add a marker in Sydney and move the camera
        //val sydney = LatLng(-34.0, 151.0)
        //map.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        //map.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        //map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,15f))
    }


    private fun observeData() {
        var local: LatLng = LatLng(-34.0, 148.0)
        var title: String = "new"
        viewModel.loading.observe(this) { loading?.isVisible = it }
        viewModel.error.observe(this) {}
        viewModel.events.observe(this) {
            adapter.updateList(it.events)
            for (item in it.events) {
                local = LatLng(
                    item.geometry.last().coordinates.last(),
                    item.geometry.last().coordinates.first()
                )
                title = item.title
                map.addMarker(MarkerOptions().position(local).title(title))
            }
        }
    }

    private fun sendToHome() {
        /*val navController = findNavController(R.id.mapsActivity)
        navController.navigate()*/
        finish()
    }

    private fun novaRequisicao(string: String) {
        viewModel.loadEventsFiltered(string, radioCheck())
        map.clear()
        gerenciarBotao(string)

    }

    fun queimadaOnClick() {
        queimadaButton?.setImageResource(R.drawable.ic_queimada_black_fundo)
        earthquakeButton?.setImageResource(R.drawable.ic_earthquake_no_back)
        iceButton?.setImageResource(R.drawable.ic_ice_no_back)
        stormButton?.setImageResource(R.drawable.ic_storm_no_back)
        landslideButton?.setImageResource(R.drawable.ic_landslide_no_back)
        vulconButton?.setImageResource(R.drawable.ic_volcano_no_back)
    }

    fun earthquakeOnClick() {
        earthquakeButton?.setImageResource(R.drawable.ic_earthquake_black_fundo)
        queimadaButton?.setImageResource(R.drawable.ic_queimada_no_back)
        iceButton?.setImageResource(R.drawable.ic_ice_no_back)
        stormButton?.setImageResource(R.drawable.ic_storm_no_back)
        landslideButton?.setImageResource(R.drawable.ic_landslide_no_back)
        vulconButton?.setImageResource(R.drawable.ic_volcano_no_back)
    }

    fun iceOnClick() {
        iceButton?.setImageResource(R.drawable.ic_ice_black_fundo)
        earthquakeButton?.setImageResource(R.drawable.ic_earthquake_no_back)
        queimadaButton?.setImageResource(R.drawable.ic_queimada_no_back)
        stormButton?.setImageResource(R.drawable.ic_storm_no_back)
        landslideButton?.setImageResource(R.drawable.ic_landslide_no_back)
        vulconButton?.setImageResource(R.drawable.ic_volcano_no_back)
    }

    fun stormOnClick() {
        stormButton?.setImageResource(R.drawable.ic_storm_black_fundo)
        earthquakeButton?.setImageResource(R.drawable.ic_earthquake_no_back)
        iceButton?.setImageResource(R.drawable.ic_ice_no_back)
        queimadaButton?.setImageResource(R.drawable.ic_queimada_no_back)
        landslideButton?.setImageResource(R.drawable.ic_landslide_no_back)
        vulconButton?.setImageResource(R.drawable.ic_volcano_no_back)
    }

    fun landslideOnClick() {
        landslideButton?.setImageResource(R.drawable.ic_landslide_black_fundo)
        earthquakeButton?.setImageResource(R.drawable.ic_earthquake_no_back)
        iceButton?.setImageResource(R.drawable.ic_ice_no_back)
        stormButton?.setImageResource(R.drawable.ic_storm_no_back)
        queimadaButton?.setImageResource(R.drawable.ic_queimada_no_back)
        vulconButton?.setImageResource(R.drawable.ic_volcano_no_back)
    }

    fun vulconOnClick() {
        vulconButton?.setImageResource(R.drawable.ic_volcano_black_fundo)
        earthquakeButton?.setImageResource(R.drawable.ic_earthquake_no_back)
        iceButton?.setImageResource(R.drawable.ic_ice_no_back)
        stormButton?.setImageResource(R.drawable.ic_storm_no_back)
        landslideButton?.setImageResource(R.drawable.ic_landslide_no_back)
        queimadaButton?.setImageResource(R.drawable.ic_queimada_no_back)
    }

    private fun gerenciarBotao(string: String) {
        if (string == "wildfires")
            queimadaOnClick()
        if (string == "earthquakes")
            earthquakeOnClick()
        if (string == "SeaLakeIce")
            iceOnClick()
        if (string == "severeStorms")
            stormOnClick()
        if (string == "landslides")
            landslideOnClick()
        if (string == "volcanoes")
            vulconOnClick()
    }


    private fun radioCheck(): String {
        if (radioOpen.isChecked)
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

    private fun sendToScreenshots() {

        /*val frame: FrameLayout = findViewById(R.id.frame_total)
        // Pega o FragmentManager
        // Pega o FragmentManager
        val fm = supportFragmentManager
// Substitui um Fragment
        val ft = fm.beginTransaction()
        frame.visibility = View.VISIBLE
        ft.replace(R.id.frame_total, ScreenshotsFragment())
        ft.commit()
        fab?.collapse()*/

        val intent = Intent(this, ScreenshotActivity::class.java)
        startActivity(intent)


    }

    private fun sendToSearch() {

        /*val frame: FrameLayout = findViewById(R.id.frame_total)
        // Pega o FragmentManager
        // Pega o FragmentManager
        val fm = supportFragmentManager
// Substitui um Fragment
        val ft = fm.beginTransaction()
        frame.visibility = View.VISIBLE
//        ft.replace(R.id.frame_total, FavoriteFragment())
        ft.commit()
        fab?.collapse()*/

        val intent = Intent(this, LocalBaseActivity::class.java)
        startActivity(intent)


    }


    private fun sendToMaps() {
        val intent = Intent(this, MapsActivity::class.java)
        startActivity(intent)


    }


    private fun takeScreenShot() {
        val now = Date()
        DateFormat.format("yyyy-mm-dd_hh:mm::ss", now)

        //val callback = GoogleMap.SnapshotReadyCallback()

        val path = getExternalFilesDir(null)?.absolutePath + "/" + now + ".jpg"
        var bitmap = Bitmap.createBitmap(
            layout_map.measuredWidth,
            layout_map.measuredHeight,
            Bitmap.Config.ARGB_8888
        )

        val sound = MediaActionSound()
        sound.play(MediaActionSound.SHUTTER_CLICK)
        //map.snapshot { bitmap -> bitmap }
        var canvas = Canvas(bitmap)
        //var canvas = Canvas(map.snapshot(callback))
        layout_map.draw(canvas)
        val imagefile = File(path)
        val outputStream = FileOutputStream(imagefile)
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
        outputStream.flush()
        outputStream.close()
        openScreenshot(imagefile)

        val URI = FileProvider.getUriForFile(
            applicationContext,
            "com.example.clima.screen.android.fileprovider",
            imagefile
        )
        val intent = Intent()
        intent.action = Intent.ACTION_SEND
        intent.putExtra(Intent.EXTRA_TEXT, "This is yout title" + "\n" + "")
        intent.putExtra(Intent.EXTRA_STREAM, URI)
        //intent.type = "text/plain"
        intent.type = "image/*"
        startActivity(intent)

    }


    fun openShareImageDialog(filePath: String) {
        val imagefile = File(filePath)
        val outputStream = FileOutputStream(imagefile)
        val URI = FileProvider.getUriForFile(
            applicationContext,
            "com.example.clima.screen.android.fileprovider",
            imagefile
        )
        val intent = Intent()
        intent.action = Intent.ACTION_VIEW
        intent.putExtra(Intent.EXTRA_TEXT, "This is yout title" + "\n" + "")
        intent.putExtra(Intent.EXTRA_STREAM, URI)
        intent.type = "text/plain"
        startActivity(intent)

    }

    private fun openScreenshot(imageFile: File) {
        val URI = FileProvider.getUriForFile(
            applicationContext,
            "com.example.clima.screen.android.fileprovider",
            imageFile
        )
        val intent = Intent()
        intent.action = Intent.ACTION_SEND
        intent.putExtra(Intent.EXTRA_TEXT, "This is yout title" + "\n" + "")
        intent.putExtra(Intent.EXTRA_STREAM, URI)
        intent.type = "text/plain"
        startActivity(intent)
    }


    private fun getScreen(bitmap: Bitmap?) {
        if (bitmap.saveImage(this)) {
            Toast.makeText(this, "Salvou!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Não Salvou!", Toast.LENGTH_SHORT).show()
        }
    }


}