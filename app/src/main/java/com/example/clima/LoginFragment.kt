package com.example.clima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewTreeLifecycleOwner.get
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.example.clima.viewmodel.ForgotPasswordFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog


class LoginFragment : Fragment(R.layout.fragment_login) {


    var cont: Int = 0
    

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val login = view.findViewById<Button>(R.id.login_button)
        val newAccount = view.findViewById<Button>(R.id.newaccount_button)

        val google = view.findViewById<ImageView>(R.id.google_button)
        val facebook = view.findViewById<ImageView>(R.id.facebook_button)


        login.setOnClickListener {
            sendToHome()
        }
        newAccount.setOnClickListener {
            sendToNewAccount()
        }

        google.setOnClickListener {
            sendToGoogle()
        }
        facebook.setOnClickListener {
            sendToFacebook()
        }
        /*forgotPassword.setOnClickListener {
            sendToForgotPassword()
        }*/
        val forgotPassword = view.findViewById<Button>(R.id.forgotpass_button)

        val dialog = ForgotPasswordFragment()

        forgotPassword.setOnClickListener {
                dialog.show(parentFragmentManager, ForgotPasswordFragment.TAG)
                Toast.makeText(context, "Apertou", Toast.LENGTH_SHORT).show()

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private fun sendToFacebook() {
        TODO("Not yet implemented")
    }

    private fun sendToGoogle() {
        TODO("Not yet implemented")
    }

    private fun sendToForgotPassword() {

    }

    private fun sendToNewAccount() {
        findNavController().navigate(R.id.action_loginFragment_to_cadastroFragment)
    }


    private fun sendToHome(){

        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
    }



}