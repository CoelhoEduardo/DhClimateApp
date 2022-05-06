package com.example.clima.screen


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.clima.R
import com.example.clima.arquitetura.network.GoogleLogInActivityContract
import com.example.clima.utils.checkEmail
import com.example.clima.bottomSheets.ForgotPasswordFragment
import com.example.clima.bottomSheets.ForgotPasswordFragment.Companion.TAG
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging


class LoginFragment : Fragment(R.layout.fragment_login) {

    private val googleSignInRequest = registerForActivityResult(
        GoogleLogInActivityContract(),
        ::onGoogleSignInResult
    )

    private val googleSignInOptions: GoogleSignInOptions
        get() = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.google_client_id))
            .requestEmail()
            .requestProfile()
            .build()

    private lateinit var auth: FirebaseAuth
    private lateinit var analytics: FirebaseAnalytics
// ...


    private val loginManager = LoginManager.getInstance()
    private val callbackManager = CallbackManager.Factory.create()


    //lateinit var googleSignInClient : GoogleSignInClient


    /*private val google: Button?
        get() = view?.findViewById(R.id.google_button)
*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize Firebase Auth
        //auth = Firebase.auth

        auth = FirebaseAuth.getInstance()
        analytics = Firebase.analytics

        val login = view.findViewById<Button>(R.id.login_button)
        val newAccount = view.findViewById<Button>(R.id.newaccount_button)
        val facebook = view.findViewById<ImageView>(R.id.facebook_button)
        val loginEdit = view.findViewById<TextInputEditText>(R.id.login_edit_text)
        val passwordText = view.findViewById<TextInputEditText>(R.id.password_edit_text)
        val forgotPassword = view.findViewById<Button>(R.id.forgotpass_button)
        val google = view.findViewById<ImageView>(R.id.google_button)

        val dialog = ForgotPasswordFragment()

        registerFacebookCallback()

        //Login via firebase
        login.setOnClickListener {
            //loginManual(loginEdit.text.toString(),passwordText.text.toString())
            loginFirebase(loginEdit.text.toString(), passwordText.text.toString())

        }


        newAccount.setOnClickListener {
            sendToNewAccount()
        }

        google?.setOnClickListener {
            //sendToGoogle()
            googleSignInRequest.launch(googleSignInOptions)
        }

        facebook.setOnClickListener {
            //sendToFacebook()
            loginFacebook()
        }

        forgotPassword.setOnClickListener {
            dialog.show(parentFragmentManager, ForgotPasswordFragment.TAG)
        }

        //getToken()

    }

    private fun getToken() {

        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w("TOKEN_FIREBASE", "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result

            // Log and toast
            Log.d("TOKEN_FIREBASE", token)
            Toast.makeText(requireContext(), "Meu token -> $token", Toast.LENGTH_SHORT).show()
        })

    }

    private fun loginFirebase(login: String, password: String) {
        if (checkEmail(login)) {
            try {
                auth.signInWithEmailAndPassword(login, password)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(requireContext(), "Sucesso no login", Toast.LENGTH_LONG)
                                .show()
                            analytics.logEvent(FirebaseAnalytics.Event.LOGIN){
                                param(FirebaseAnalytics.Param.METHOD, "login_email")
                            }
                            sendToHome()
                        } else {
                            Toast.makeText(requireContext(), "Erro!", Toast.LENGTH_LONG).show()
                        }
                    }

            } catch (e: Exception) {
            }
        } else {
            Toast.makeText(context, "Email Invalido", Toast.LENGTH_SHORT).show()
        }

    }

    private fun registerFacebookCallback() {
        loginManager.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onCancel() {
                Toast.makeText(requireContext(), "Cancelou", Toast.LENGTH_LONG).show()
            }

            override fun onError(error: FacebookException) {
                Toast.makeText(requireContext(), "Erro!", Toast.LENGTH_LONG).show()
                println(error)
            }

            override fun onSuccess(result: LoginResult) {
                val token = result.accessToken.token
                analytics.logEvent(FirebaseAnalytics.Event.LOGIN){
                    param(FirebaseAnalytics.Param.METHOD, "login_facebook")
                }
                sendToHome()
                //Toast.makeText(requireContext(),"Esse e o nosso token -> $token", Toast.LENGTH_LONG).show()
                Toast.makeText(requireContext(), "Sucesso no login", Toast.LENGTH_LONG).show()
            }


        }
        )
    }

    private fun loginFacebook() {
        loginManager.logInWithReadPermissions(
            this,
            callbackManager,
            arrayListOf("public_profile", "email")
        )


    }

    private fun onGoogleSignInResult(result: GoogleLogInActivityContract.Result?) {
        if (result is GoogleLogInActivityContract.Result.Success) {
            val token = result.googleSignInAccount.idToken
            analytics.logEvent(FirebaseAnalytics.Event.LOGIN){
                param(FirebaseAnalytics.Param.METHOD, "login_google")
            }
            sendToHome()
            Toast.makeText(requireContext(), "Sucesso no login", Toast.LENGTH_LONG).show()
            //retorna token
            //Toast.makeText(requireContext(), "Meu token do google e -> $token", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(requireContext(), "Erro", Toast.LENGTH_LONG).show()
        }
    }

    private fun sendToNewAccount() {
        findNavController().navigate(R.id.action_loginFragment_to_cadastroFragment)
    }

    private fun sendToHome() {
        findNavController().navigate(R.id.action_loginFragment_to_mapsActivity)
        /*val intent = Intent(this, MapsActivity::class.java)
        startActivity(intent)*/

    }

    private fun loginManual(login: String, password: String) {
        if (checkEmail(login)) {
            try {
                validarLogin(login, password)
                sendToHome()
            } catch (e: Exception) {
            }
        } else {
            Toast.makeText(context, "Email Invalido", Toast.LENGTH_SHORT).show()
        }
    }


    private fun validarLogin(email: String, senha: String) {

    }


}