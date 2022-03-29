package com.example.clima.Utils

import java.util.regex.Pattern



    val EMAIL_ADDRESS_PATTERN: Pattern = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

val SENHA_PATTERN: Pattern = Pattern.compile(
    "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=.])(?=\\S+\$).{8,20}\$"
)

public fun checkEmail(email: String): Boolean {
    return EMAIL_ADDRESS_PATTERN.matcher(email).matches()
}

public fun checkSenha(senha: String): Boolean {
    return SENHA_PATTERN.matcher(senha).matches()
}

