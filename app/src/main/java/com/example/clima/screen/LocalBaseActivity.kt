package com.example.clima.screen


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

class LocalBaseActivity : AppCompatActivity() {

    private val loading: FrameLayout?
        get() = findViewById(R.id.loadingLocal)
    private val adapter = FavoriteAdapter()
    private val recycler: RecyclerView?
        get() = findViewById(R.id.local_recycler)
    private val home: ImageView?
        get() = findViewById(R.id.home)
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
}