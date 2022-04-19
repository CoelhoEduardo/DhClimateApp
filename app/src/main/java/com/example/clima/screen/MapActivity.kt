//package com.example.clima.screen
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.*
//import androidx.activity.viewModels
//import androidx.core.view.isVisible
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.clima.R
//import com.example.clima.mock.Search
//import com.example.clima.adapters.SearchAdapter
//import com.example.clima.arquitetura.local.AppDataBase
//import com.example.clima.arquitetura.local.entity.EventsEntity
//import com.example.clima.utils.extension.loadRectangle
//import com.example.clima.views.viewModel.MapViewModel
//
//
//class MapActivity : AppCompatActivity() {
//
//
//    private val adapter = SearchAdapter()
//
//    val imageUrl: String =
//        "https://www.researchgate.net/profile/Tiago-Tamagusko/publication/343628852/figure/fig11/AS:924018139987968@1597314500101/Figura-21-Mapa-America-do-Sul-Fonte-Google-Maps-https-mapsgooglecombr.jpg"
//
//    private val viewModel: MapViewModel by viewModels()
//
//    private val button: ImageButton
//        get() = findViewById(R.id.queimada_button)
//    private val recycler: RecyclerView
//        get() = findViewById(R.id.recycler_maps)
//    private val loading: FrameLayout
//        get() = findViewById(R.id.loading)
//    private val image: ImageView
//        get() = findViewById(R.id.map_image)
//
//
//    private lateinit var eventsRoom: AppDataBase
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_map)
//
//        image.loadRectangle(imageUrl)
//
//        eventsRoom = DatabaseFactory.getDatabase()
//        save()
//        recycler.adapter = adapter
//        setScrollView()
//
//        viewModel.loadEvents()
//        observeData()
//
//    }
//
//    private fun setScrollView() {
//        recycler.run {
//            addOnScrollListener(object : RecyclerView.OnScrollListener() {
//                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                    super.onScrolled(recyclerView, dx, dy)
//
//                    val target = recyclerView.layoutManager as LinearLayoutManager
//                    val totalCountItems = target.itemCount
//                    val lastItemVisible = target.findLastVisibleItemPosition()
//
//                    val lastItem = lastItemVisible + 5 >= totalCountItems
//
//                    if ((totalCountItems > 0 && lastItem)) {
//                        viewModel.loadEvents()
//                    }
//                }
//
//            })
//        }
//    }
//
//    private fun save() {
//        val myEvents = EventsEntity(
//            title = "Queimada",
//            date = "10/05/2022",
//            location = "São Paulo"
//        )
//
//        eventsRoom.acessEvents().insert(myEvents)
//        val events = eventsRoom.acessEvents().listAll()
//        println(events)
//    }
//
//
//    fun observeData() {
//        viewModel.loading.observe(this) { loading.isVisible = it }
//        viewModel.error.observe(this) {
//            if (it)
//                Toast.makeText(this, "Deu Erro", Toast.LENGTH_LONG).show()
//        }
//        viewModel.events.observe(this) {
//            Toast.makeText(this, "Deu Certo", Toast.LENGTH_LONG).show()
//            adapter.updateList(it?.properties ?: emptyList())
//        }
//    }
//
//
//    private fun buscarEndereco() {
//        val listSearch = MutableList(10) {
//            Search(
//                image = "https://upload.wikimedia.org/wikipedia/commons/8/8c/Cristiano_Ronaldo_2018.jpg",
//                local = "Sao Paulo,SP - Brasil", data = "22 MAI 2022"
//
//            )
//        }
//
//    }
//
//    override fun onStop() {
//        DatabaseFactory.destroyInstance()
//        super.onStop()
//    }
//
//
//}
