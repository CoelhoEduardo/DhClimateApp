package com.example.clima.screen

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clima.R
import com.example.clima.adapters.ScreenshotAdapterNew
import com.example.clima.adapters.SearchAdapter
import com.example.clima.mock.ImagesBitmap
import com.getbase.floatingactionbutton.FloatingActionButton
import com.getbase.floatingactionbutton.FloatingActionsMenu
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import retrofit2.http.Url
import java.io.File


class ScreenshotActivity : AppCompatActivity() {

    private val adapter = ScreenshotAdapterNew(){
        var image = it.imageUrl
        openImage(image)
    }

    private fun openImage(url: String) {
        val intent = Intent(this, ScreenshotFullActivity::class.java)
        intent.putExtra("URL",url)
        startActivity(intent)
    }


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

    private val list = mutableListOf<ImagesBitmap>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screenshot)

        var gpath: String = Environment.getExternalStorageDirectory().absolutePath
        var spath = "Pictures/APP"
        var fullpath = File(gpath + File.separator + spath)
        var fullpath2 = File(gpath + File.separator + spath + "/map-1651879319586.jpg")
        Log.w("fullpath", "" + fullpath)

        recycler.layoutManager = GridLayoutManager(this, 3)
        recycler.adapter = adapter

        home?.setOnClickListener {
            sendToHome()
        }

        fab1?.setOnClickListener {
            sendToSearch()
        }
        fab2?.setOnClickListener {

            sendToMaps()
        }
        home.setOnClickListener {
            val intent = Intent(this, ScreenshotFullActivity::class.java)
            intent.putExtra("URL",fullpath2.toString())
            startActivity(intent)
        }

        observe()

    }

    private fun observe() {
        var gpath: String = Environment.getExternalStorageDirectory().absolutePath
        var spath = "Pictures/APP"
        var fullpath = File(gpath + File.separator + spath)
        imageReaderNew(fullpath)
        adapter.updateList(list)
    }


    private fun sendToSearch() {
        val intent = Intent(this, LocalBaseActivity::class.java)
        startActivity(intent)

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
    }


    private fun sendToHome() {

        //findNavController().navigate(R.id.action_screenshotsFragment_to_homeFragment)
    }


    private fun sendToMaps() {
        val intent = Intent(this, MapsActivity::class.java)
        startActivity(intent)
        //findNavController().navigate(R.id.action_screenshotsFragment_to_mapsActivity)
    }

    fun imageReaderNew(root: File): ArrayList<File> {
        val fileList: ArrayList<File> = ArrayList()
        val listAllFiles = root.listFiles()

        if (listAllFiles != null && listAllFiles.size > 0) {
            for (currentFile in listAllFiles) {
                if (currentFile.name.endsWith(".jpg")) {
                    // File absolute path
                    Log.e("downloadFilePath", currentFile.getAbsolutePath())
                    // File Name
                    Log.e("downloadFileName", currentFile.getName())
                    fileList.add(currentFile.absoluteFile)
                    var image = ImagesBitmap(currentFile.absolutePath.toString())
println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")

                    println(image)
                    list.add(image)
                }
            }
            Log.w("fileList", "" + fileList.size)
        }
        return fileList
    }
}
