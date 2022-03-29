package com.example.clima

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.clima.Model.Maps.Usuario
import com.example.clima.Utils.checkEmail
import com.example.clima.Utils.checkSenha
import com.example.clima.viewmodel.ForgotPasswordFragment
import com.example.clima.viewmodel.NewAccountFragment
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.delay
import java.lang.Exception

class CadastroFragment : Fragment(R.layout.fragment_cadastro) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val criarConta = view.findViewById<Button>(R.id.criar_conta_button)
        val temConta = view.findViewById<Button>(R.id.temConta_button)
        val nome = view.findViewById<TextInputEditText>(R.id.nome_edit_text)
        val pais = view.findViewById<TextInputEditText>(R.id.pais_edit_text)
        val email = view.findViewById<TextInputEditText>(R.id.email_edit_text)
        val senha1 = view.findViewById<TextInputEditText>(R.id.senha_edit_text)
        val senha2 = view.findViewById<TextInputEditText>(R.id.senha2_edit_text)

        val dialog = NewAccountFragment()

        criarConta.setOnClickListener{
            if (checkEmail(email.text.toString())) {
                if(validarSenha(senha1.text.toString(),senha2.text.toString())){
                    try {
                        criarConta(nome.text.toString(),pais.text.toString(),email.text.toString(), senha1.text.toString())
                        dialog.show(parentFragmentManager, ForgotPasswordFragment.TAG)
                        sendToLogin()
                    } catch (e: Exception) {
                        Toast.makeText(context, "Nao foi possivel criar sua conta", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(context, "Senha Invalida", Toast.LENGTH_SHORT).show()
                }

            } else {
                Toast.makeText(context, "Email Invalido", Toast.LENGTH_SHORT).show()
            }
        }
        temConta.setOnClickListener{
            sendToLogin()
        }


    }

    private fun validarSenha(senha1: String, senha2: String): Boolean {
        return if(senha1 == senha2){
            checkSenha(senha1)
        }else{
            false
        }

    }

    private fun criarConta(nome: String, pais: String, email: String, senha: String) {
        var user = Usuario(nome,pais,email,senha)
        // criar conta do usuario

    }


    private fun sendToHome(){

        findNavController().navigate(R.id.action_cadastroFragment_to_homeFragment)
    }

    private fun sendToLogin(){

        findNavController().navigate(R.id.action_cadastroFragment_to_loginFragment)
    }

}