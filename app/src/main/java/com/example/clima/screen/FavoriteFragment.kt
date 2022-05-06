//package com.example.clima.screen
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.View
//import android.widget.ImageView
//import androidx.navigation.fragment.findNavController
//import androidx.recyclerview.widget.RecyclerView
//import com.example.clima.R
//import com.example.clima.mock.Maps.Favorite
//import com.example.clima.mock.Maps.FavoriteImage
//import com.example.clima.adapters.FavoriteAdapter
//import com.example.clima.arquitetura.factory.DatabaseFactory
//import com.example.clima.arquitetura.local.AppDataBase
//import com.example.clima.arquitetura.response.EventsItem
//
//class FavoriteFragment : Fragment(R.layout.fragment_favorite) {
//
//    private lateinit var database: AppDataBase
//    init {
//        database = DatabaseFactory.getDatabase()
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        val listFavorite = mutableListOf<Favorite>(
//            FavoriteImage(
//                "https://tm.ibxk.com.br/2021/12/20/20095730932072.jpg?ims=1200x675",
//                "QUEIMADAS"
//
//            ),
//            FavoriteImage(
//                "https://tm.ibxk.com.br/2021/12/20/20095730932072.jpg?ims=1200x675",
//                "QUEIMADAS"
//            ),
//            FavoriteImage(
//                "https://tm.ibxk.com.br/2021/12/20/20095730932072.jpg?ims=1200x675",
//                "QUEIMADAS"
//            ),
//        )
//
//        val saveList = database.acessEvents().listAll()
//
//
//        val profile = view.findViewById<ImageView>(R.id.profile)
//        val home = view.findViewById<ImageView>(R.id.home)
//        val recycler = view.findViewById<RecyclerView>(R.id.favorite_recycler)
//        recycler.adapter = FavoriteAdapter(saveList)
//
//        profile.setOnClickListener{
//            sendToPreferences()
//        }
//
//        home.setOnClickListener{
//            sendToHome()
//        }
//
//    }
//
//    private fun sendToPreferences() {
//
//        findNavController().navigate(R.id.action_favoriteFragment_to_preferencesFragment)
//    }
//
//    private fun sendToHome() {
//
//        findNavController().navigate(R.id.action_favoriteFragment_to_homeFragment)
//    }
//}
