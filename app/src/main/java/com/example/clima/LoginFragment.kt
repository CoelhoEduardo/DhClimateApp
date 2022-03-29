package com.example.clima


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.clima.Utils.checkEmail
import com.example.clima.viewmodel.ForgotPasswordFragment
import com.google.android.material.textfield.TextInputEditText
import java.lang.Exception


class LoginFragment : Fragment(R.layout.fragment_login) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val login = view.findViewById<Button>(R.id.login_button)
        val newAccount = view.findViewById<Button>(R.id.newaccount_button)
        val google = view.findViewById<ImageView>(R.id.google_button)
        val facebook = view.findViewById<ImageView>(R.id.facebook_button)
        val loginEdit = view.findViewById<TextInputEditText>(R.id.login_edit_text)
        val passwordText = view.findViewById<TextInputEditText>(R.id.password_edit_text)
        val forgotPassword = view.findViewById<Button>(R.id.forgotpass_button)

        val dialog = ForgotPasswordFragment()

        login.setOnClickListener {
            if (checkEmail(loginEdit.text.toString())) {
                try {
                    validarLogin(loginEdit.text.toString(), passwordText.text.toString())
                    sendToHome()
                } catch (e: Exception) {
                }
            } else {
                Toast.makeText(context, "Email Invalido", Toast.LENGTH_SHORT).show()
            }

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

        forgotPassword.setOnClickListener {
            dialog.show(parentFragmentManager, ForgotPasswordFragment.TAG)
            Toast.makeText(context, "Apertou", Toast.LENGTH_SHORT).show()

        }

    }

    private fun validarLogin(email: String, senha: String) {

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


    private fun sendToHome() {

        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
    }


}