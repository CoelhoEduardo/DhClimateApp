/*
package com.example.clima.utils

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale
import androidx.core.content.ContextCompat
import com.example.clima.R
import com.example.clima.mock.Screenshot
import com.example.clima.screen.ScreenshotActivity

private val MEDIA_CONTENT_CONTROL_RESULT_CODE = 111

public fun checkPermissionMedia(context : Context){
    if (ContextCompat.checkSelfPermission(context, Manifest.permission.MEDIA_CONTENT_CONTROL) != PackageManager.PERMISSION_GRANTED) {
        // Permissão ainda não foi concedida
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.MEDIA_CONTENT_CONTROL) != PackageManager.PERMISSION_GRANTED) {
            // Verifica se o usuário já negou acesso a permisão
            if (shouldShowRequestPermissionRationale(Manifest.permission.MEDIA_CONTENT_CONTROL)) {
                // Usuário negou acesso
                // Mostrar uma dialog explicando a importância do app ter acesso a funcionalidade
                AlertDialog.Builder(context).apply {
                    setMessage(R.string.more_info_dialog_message)
                    setTitle(R.string.more_info_dialog_title)
                    setPositiveButton(R.string.yes_please) { d, i ->
                        // Se o usuário quiser, requere novamente permissão à funcionalidade
                        ActivityCompat.requestPermissions(
                            Activity(),
                            arrayOf(Manifest.permission.MEDIA_CONTENT_CONTROL),
                            MEDIA_CONTENT_CONTROL_RESULT_CODE)
                    }
                    // Se o usuário optar por não conceder a permissão, fecha a dialog
                    setNegativeButton(R.string.no_thanks) { d, i -> d.dismiss() }
                }.show()
            } else {
                // Usuário não negou acesso ou negou e marcou a caixa de "não perguntar novamente"
                // Fazer a requisição da permissão
                ActivityCompat.requestPermissions(
                    Activity(),
                    arrayOf(Manifest.permission.MEDIA_CONTENT_CONTROL),
                    MEDIA_CONTENT_CONTROL_RESULT_CODE)
            }
        }
    } else {
        // Permissão já foi concedida, já é possível usufruir da funcionalidade
    }
}
override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
    when (requestCode) {
        CALL_PHONE_RESULT_CODE -> {
            // Gerenciar o resultado da requisição
        }
    }
}*/
