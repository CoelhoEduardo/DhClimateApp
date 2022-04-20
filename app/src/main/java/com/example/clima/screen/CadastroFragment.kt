package com.example.clima.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.clima.R
import com.example.clima.mock.Usuario
import com.example.clima.utils.checkEmail
import com.example.clima.utils.checkSenha
import com.example.clima.bottomSheets.ForgotPasswordFragment
import com.example.clima.bottomSheets.NewAccountFragment
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import java.lang.Exception

class CadastroFragment : Fragment(R.layout.fragment_cadastro) {

    private lateinit var auth: FirebaseAuth

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
        auth = FirebaseAuth.getInstance()

        criarConta.setOnClickListener {
            if (criarConta(
                    nome.text.toString(),
                    pais.text.toString(),
                    email.text.toString(),
                    senha1.text.toString(),
                    senha2.text.toString()
                )
            ) {
                sendToLogin()
                dialog.show(parentFragmentManager, ForgotPasswordFragment.TAG)
            }
            /* if (checkEmail(email.text.toString())) {
                 if (validarSenha(senha1.text.toString(), senha2.text.toString())) {
                     try {
                         auth.createUserWithEmailAndPassword(
                             email.text.toString(),
                             senha1.text.toString()
                         ).addOnCompleteListener {
                             if (it.isSuccessful) {
                                 Toast.makeText(
                                     requireContext(),
                                     "Cadastrado com sucesso",
                                     Toast.LENGTH_LONG
                                 ).show()
                                 dialog.show(parentFragmentManager, ForgotPasswordFragment.TAG)
                                 sendToLogin()
                             } else {
                                 Toast.makeText(
                                     requireContext(),
                                     "Erro no cadastro!",
                                     Toast.LENGTH_LONG
                                 ).show()
                             }
                         }
                     } catch (e: Exception) {
                         Toast.makeText(
                             context,
                             "Nao foi possivel criar sua conta",
                             Toast.LENGTH_SHORT
                         ).show()
                     }
                 } else {
                     Toast.makeText(context, "Senha Invalida", Toast.LENGTH_SHORT).show()
                 }

             } else {
                 Toast.makeText(context, "Email Invalido", Toast.LENGTH_SHORT).show()
             }*/

            /*
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
            }*/
        }
        temConta.setOnClickListener {
            sendToLogin()
        }


    }

    private fun validarSenha(senha1: String, senha2: String): Boolean {
        return if (senha1 == senha2) {
            checkSenha(senha1)
        } else {
            false
        }

    }

    private fun criarConta(
        nome: String,
        pais: String,
        email: String,
        senha: String,
        senha2: String
    ): Boolean {
        var user = Usuario(nome, email, pais, senha)

        if (checkEmail(email)) {
            if (validarSenha(senha, senha2)) {
                try {
                    auth.createUserWithEmailAndPassword(
                        email,
                        senha
                    ).addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(
                                requireContext(),
                                "Cadastrado com sucesso",
                                Toast.LENGTH_LONG
                            ).show()
                        } else {
                            Toast.makeText(
                                requireContext(),
                                "Erro no cadastro!",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                } catch (e: Exception) {
                    Toast.makeText(
                        context,
                        "Nao foi possivel criar sua conta",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(context, "Senha Invalida", Toast.LENGTH_SHORT).show()
                return false
            }

        } else {
            Toast.makeText(context, "Email Invalido", Toast.LENGTH_SHORT).show()
            return false
        }
        return true


        // criar conta do usuario
    }


    private fun sendToHome() {

        findNavController().navigate(R.id.action_cadastroFragment_to_homeFragment)
    }

    private fun sendToLogin() {

        findNavController().navigate(R.id.action_cadastroFragment_to_loginFragment)
    }

}