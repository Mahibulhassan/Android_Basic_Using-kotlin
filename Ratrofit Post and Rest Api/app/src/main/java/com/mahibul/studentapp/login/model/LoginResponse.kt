package com.mahibul.studentapp.login.model

data class LoginResponse(
    val message: String?,
    val status: Boolean?,
    val token: String?
)