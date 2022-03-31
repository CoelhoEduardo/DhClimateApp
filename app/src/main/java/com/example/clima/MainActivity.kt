package com.example.clima

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Base64
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        val info: PackageInfo = getPackageManager().getPackageInfo(
            "com.example.clima",
            PackageManager.GET_SIGNATURES
        )
        for (signature in info.signatures) {
            val md: MessageDigest = MessageDigest.getInstance("SHA")
            md.update(signature.toByteArray())
            Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT))
        }

    }



}








