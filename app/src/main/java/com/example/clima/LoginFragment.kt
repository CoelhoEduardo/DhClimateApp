package com.example.clima

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.findNavController

class LoginFragment : Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val login = view.findViewById<Button>(R.id.login_button)
        val newAccount = view.findViewById<Button>(R.id.newaccount_button)
        val forgotPassword = view.findViewById<Button>(R.id.forgotpass_button)
        val google = view.findViewById<ImageView>(R.id.google_button)
        val facebook = view.findViewById<ImageView>(R.id.facebook_button)



        login.setOnClickListener{
            sendToHome()
        }
        newAccount.setOnClickListener{
            sendToNewAccount()
        }
        forgotPassword.setOnClickListener{
            sendToForgotPassword()
        }
        google.setOnClickListener{
            sendToGoogle()
        }
        facebook.setOnClickListener{
            sendToFacebook()
        }


    }

    private fun sendToFacebook() {
        TODO("Not yet implemented")
    }

    private fun sendToGoogle() {
        TODO("Not yet implemented")
    }

    private fun sendToForgotPassword() {
        TODO("Not yet implemented")
    }

    private fun sendToNewAccount() {
        findNavController().navigate(R.id.action_loginFragment_to_cadastroFragment)
    }


    private fun sendToHome(){

        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
    }



}