package com.example.clima

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.findNavController

class CadastroFragment : Fragment(R.layout.fragment_cadastro) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val criarConta = view.findViewById<Button>(R.id.criar_conta_button)
        val temConta = view.findViewById<Button>(R.id.temConta_button)



        criarConta.setOnClickListener{
            sendToHome()
        }
        temConta.setOnClickListener{
            sendToLogin()
        }


    }


    private fun sendToHome(){

        findNavController().navigate(R.id.action_cadastroFragment_to_homeFragment)
    }

    private fun sendToLogin(){

        findNavController().navigate(R.id.action_cadastroFragment_to_loginFragment)
    }

}