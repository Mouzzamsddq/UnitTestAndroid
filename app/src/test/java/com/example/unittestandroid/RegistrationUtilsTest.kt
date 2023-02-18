package com.example.unittestandroid

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilsTest {

    @Test
    fun `empty username returns false`() {
        val result = RegistrationUtils.validateRegistrationInput(
            username = "",
            password = "123",
            confirmPassword = "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `valid username and correctly repeated password returns true`() {
        val result = RegistrationUtils.validateRegistrationInput(
            username = "Deeksha",
            password = "123",
            confirmPassword = "123"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun `username already exist returns false`() {
        val result = RegistrationUtils.validateRegistrationInput(
            username = "Mouzzam",
            password = "123",
            confirmPassword = "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `empty password return false`() {
        val result = RegistrationUtils.validateRegistrationInput(
            username = "Mouzzam",
            password = "",
            confirmPassword = ""
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `mismatch password return false`() {
        val result = RegistrationUtils.validateRegistrationInput(
            username = "Mouzzam",
            password = "12345",
            confirmPassword = "54321"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `less than 2 digit password return false`() {
        val result = RegistrationUtils.validateRegistrationInput(
            username = "Mouzzam",
            password = "abcd1",
            confirmPassword = "abcd1"
        )
        assertThat(result).isFalse()
    }
}
