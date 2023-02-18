package com.example.unittestandroid

object RegistrationUtils {

    private val existingUsers = listOf("Mouzzam", "Sumanta")

    /**
     * The input is not  valid if...
     * ... the username/password is empty
     * ... the username is already taken
     * ... the confirm password is not same as real password
     * ... the password contains less than 2 digits
     */
    fun validateRegistrationInput(
        username: String,
        password: String,
        confirmPassword: String
    ): Boolean {
        if (username.isEmpty() || password.isEmpty()) {
            return false
        }
        if (username in existingUsers) {
            return false
        }
        if (password != confirmPassword) {
            return false
        }
        if (password.count { it.isDigit() } < 2) {
            return false
        }
        return true
    }
}
