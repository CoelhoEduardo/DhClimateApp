package com.example.clima.screen


import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.clima.R
import com.example.clima.adapters.FavoriteAdapter
import com.example.clima.arquitetura.factory.DatabaseFactory
import com.example.clima.views.viewModel.MapViewModel
import com.getbase.floatingactionbutton.FloatingActionButton
import com.getbase.floatingactionbutton.FloatingActionsMenu

class LocalBaseActivity : AppCompatActivity() {

    private val loading: FrameLayout?
        get() = findViewById(R.id.loadingLocal)
    private val adapter = FavoriteAdapter()
    private val recycler: RecyclerView?
        get() = findViewById(R.id.local_recycler)
    private val home: ImageView?
        get() = findViewById(R.id.home)
    val fab: FloatingActionsMenu?
        get() = findViewById(R.id.fab)
    val fab1: FloatingActionButton?
        get() = findViewById(R.id.fab1)
    val fab2: FloatingActionButton?
        get() = findViewById(R.id.fab2)

    private val viewModelLocal: MapViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_local_base)

        recycler?.adapter = adapter
        viewModelLocal.loadEvents()
        viewModelLocal.loadData()
        savedData()

        home?.setOnClickListener{
           sendToHome()
        }

        fab1?.setOnClickListener {

            sendToMaps()
        }
        fab2?.setOnClickListener {
            sendToScreenshot()

        }

    }

    private fun savedData(){
        viewModelLocal.loading.observe(this) { loading?.isVisible = it }
        viewModelLocal.events.observe(this){
            adapter.updateList(it.events) }
    }

    private fun sendToHome() {
        finish()
    }

    override fun onStop() {
        DatabaseFactory.destroyInstance()
        super.onStop()

    }

    private fun sendToMaps(){
        val intent = Intent(this, MapsActivity::class.java)
        startActivity(intent)


    }

    private fun sendToScreenshot(){
        val intent = Intent(this, ScreenshotActivity::class.java)
        startActivity(intent)


    }

}