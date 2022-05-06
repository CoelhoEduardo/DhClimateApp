package com.example.clima.bottomSheets

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.clima.R
import com.example.clima.utils.checkEmail
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth


class ForgotPasswordFragment : BottomSheetDialogFragment() {


    private lateinit var auth: FirebaseAuth

    @SuppressLint("InflateParams")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        auth = FirebaseAuth.getInstance()

        val dialog = super.onCreateDialog(savedInstanceState)
        val view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_forgot_password, null)
        dialog.setContentView(view)
        return dialog
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.BottomSheetDialog)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.bottom_sheet_forgot_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val forgotBtn = view.findViewById<Button>(R.id.forgot_button)
        val closeBtn = view.findViewById<Button>(R.id.close_button)
        val textMessage = view.findViewById<TextView>(R.id.text_message)
        val email = view.findViewById<TextInputEditText>(R.id.text_email)


        forgotBtn.setOnClickListener {
            if (checkEmail(email.text.toString())) {
                try {
                    recuperarSenha(email.text.toString())
                    forgotBtn.visibility = View.INVISIBLE
                    closeBtn.visibility = View.VISIBLE
                    textMessage.visibility = View.VISIBLE
                } catch (e: Exception) {
                }
            } else {
                Toast.makeText(context, "Email Invalido", Toast.LENGTH_SHORT).show()
            }


        }

        closeBtn.setOnClickListener {
            dismiss()
        }

    }

    private fun recuperarSenha(text: String) {
        auth.sendPasswordResetEmail(text).addOnSuccessListener {
        }
        auth.sendPasswordResetEmail(text).addOnFailureListener {
            if (checkEmail(text)) {
                Toast.makeText(context, "Erro ao enviar email", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Email Invalido", Toast.LENGTH_SHORT).show()
            }
        }
    }


    companion object {

        const val TAG = "CustomBottomSheetDialogFragment"

    }
}
