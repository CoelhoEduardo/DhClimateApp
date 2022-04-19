package com.example.clima.screen


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.clima.R
import com.example.clima.utils.GoogleLogInActivityContract
import com.example.clima.utils.checkEmail
import com.example.clima.bottomSheets.ForgotPasswordFragment
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.textfield.TextInputEditText


class LoginFragment : Fragment(R.layout.fragment_login) {

    private val googleSignInRequest = registerForActivityResult(
        GoogleLogInActivityContract(),
        ::onGoogleSignInResult
    )

    private val googleSignInOptions : GoogleSignInOptions
        get() = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.google_client_id))
            .requestEmail()
            .requestProfile()
            .build()


    private val loginManager = LoginManager.getInstance()
    private val callbackManager = CallbackManager.Factory.create()


    //lateinit var googleSignInClient : GoogleSignInClient


    /*private val google: Button?
        get() = view?.findViewById(R.id.google_button)
*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val login = view.findViewById<Button>(R.id.login_button)
        val newAccount = view.findViewById<Button>(R.id.newaccount_button)
        val facebook = view.findViewById<ImageView>(R.id.facebook_button)
        val loginEdit = view.findViewById<TextInputEditText>(R.id.login_edit_text)
        val passwordText = view.findViewById<TextInputEditText>(R.id.password_edit_text)
        val forgotPassword = view.findViewById<Button>(R.id.forgotpass_button)
        val google = view.findViewById<ImageView>(R.id.google_button)

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

        //googleSignInClient = GoogleSignIn.getClient(view.context, googleSignInOptions)

        google?.setOnClickListener {
            //sendToGoogle()
            googleSignInRequest.launch(googleSignInOptions)
        }

        facebook.setOnClickListener {
            //sendToFacebook()
            loginFacebook()
        }

        registerFacebookCallback()

        forgotPassword.setOnClickListener {
            dialog.show(parentFragmentManager, ForgotPasswordFragment.TAG)

        }

    }

    private fun registerFacebookCallback() {
        loginManager.registerCallback(callbackManager, object: FacebookCallback<LoginResult>{
            override fun onCancel() {
                Toast.makeText(requireContext(),"Cancelou", Toast.LENGTH_LONG).show()
            }

            override fun onError(error: FacebookException) {
                Toast.makeText(requireContext(),"Erro!", Toast.LENGTH_LONG).show()
                println(error)
            }

            override fun onSuccess(result: LoginResult) {
                val token = result.accessToken.token
                sendToHome()
                //Toast.makeText(requireContext(),"Esse e o nosso token -> $token", Toast.LENGTH_LONG).show()
                Toast.makeText(requireContext(),"Sucesso no login", Toast.LENGTH_LONG).show()
            }


        }
        )
    }

    private fun loginFacebook() {
        loginManager.logInWithReadPermissions(
            this,
            callbackManager,
            arrayListOf("public_profile", "email"))


    }

    private fun sendToNewAccount() {
        findNavController().navigate(R.id.action_loginFragment_to_cadastroFragment)
    }

    private fun sendToHome() {

        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
    }

    private fun onGoogleSignInResult(result: GoogleLogInActivityContract.Result?) {
        if(result is GoogleLogInActivityContract.Result.Success){
            val token = result.googleSignInAccount.idToken
            sendToHome()
            Toast.makeText(requireContext(),"Sucesso no login", Toast.LENGTH_LONG).show()
            //retorna token
            //Toast.makeText(requireContext(), "Meu token do google e -> $token", Toast.LENGTH_LONG).show()
        }
    }

    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }*/

    private fun validarLogin(email: String, senha: String) {

    }


}