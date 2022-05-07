package com.example.clima.screen

import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewTreeLifecycleOwner.get
import com.example.clima.R
import java.io.File


class ScreenshotFullActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screenshot_full)

        val image = findViewById<ImageView>(R.id.image)

        var gpath: String = Environment.getExternalStorageDirectory().absolutePath
        var spath = "Pictures/APP"


        val bundle = intent.extras
        println(bundle?.get("URL"))
        val url = bundle?.getString("URL")
        println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")
        println( url)
        var fullpath = File(gpath + File.separator + spath + url)
        if(url != null) {
            var folder = File(url)
            val myBitmap = BitmapFactory.decodeFile(folder.getAbsolutePath())
            image.setImageBitmap(myBitmap)
        }
    }
}