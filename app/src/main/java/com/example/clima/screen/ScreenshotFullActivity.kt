package com.example.clima.screen

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.example.clima.R
import com.getbase.floatingactionbutton.FloatingActionButton
import com.getbase.floatingactionbutton.FloatingActionsMenu
import java.io.File


class ScreenshotFullActivity : AppCompatActivity() {

    var gpath: String = Environment.getExternalStorageDirectory().absolutePath
    var spath = "Pictures/APP"

    val fab: FloatingActionsMenu?
        get() = findViewById<FloatingActionsMenu>(R.id.fab)
    val compartilhar: FloatingActionButton?
        get() = findViewById<FloatingActionButton>(R.id.fab1)
    val excluir: FloatingActionButton?
        get() = findViewById<FloatingActionButton>(R.id.fab2)

    val back: ImageView?
        get() = findViewById<ImageView>(R.id.back)

    val image: ImageView
        get() = findViewById<ImageView>(R.id.image)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screenshot_full)


        //checkPermissionMedia(this)


        val bundle = intent.extras
        val url = bundle?.getString("URL")
        var fullpath = File(gpath + File.separator + spath + url)
        if (url != null) {
            var folder = File(url)
            val myBitmap = BitmapFactory.decodeFile(folder.getAbsolutePath())
            image.setImageBitmap(myBitmap)
        }

        compartilhar?.setOnClickListener {
            shareScreenshot(url)
        }
        excluir?.setOnClickListener {


            deleteScreenshot(url)


        }
        back?.setOnClickListener {
            finish()
        }


    }

    private fun sendScreenshot() {
        val intent = Intent(this, ScreenshotActivity::class.java)
        startActivity(intent)
    }


    private fun shareScreenshot(url: String?) {
        val path = url?.subSequence(19, url.length)
        var file = File("/sdcard" + path)
        val URI = FileProvider.getUriForFile(
            applicationContext,
            "com.example.clima.screen.android.fileprovider",
            file
        )
        val intent = Intent()
        intent.action = Intent.ACTION_SEND
        //intent.putExtra(Intent.EXTRA_TEXT,"Veja esses eventos climaticos"+"\n"+ "")
        intent.putExtra(Intent.EXTRA_STREAM, URI)
        intent.type = "image/*"
        startActivity(intent)
    }

    private fun deleteScreenshot(url: String?) {
        AlertDialog.Builder(this).apply {
            setIcon(R.drawable.ic_delete_black)
            //setMessage(R.string.more_info_dialog_message)
            setTitle(R.string.more_info_dialog_message)
            setPositiveButton(R.string.yes_please) { d, i ->
                val path = url?.subSequence(19, url.length)
                var file = File("/sdcard" + path)
                if (file.exists()) {
                    if (file.delete()) {
                        println("file Deleted :$file")
                        Toast.makeText(context, "Screenshot Excluido!", Toast.LENGTH_SHORT).show()
                        sendScreenshot()
                    } else {
                        println("file not Deleted :$file")
                    }
                } else {
                    println("file not exist :$file")
                }
            }
            // Se o usuário optar por não conceder a permissão, fecha a dialog
            setNegativeButton(R.string.no_thanks) { d, i -> d.dismiss() }
        }.show()
    }
}