package br.dev.io.kb_api_kotlin.presentation.dto

data class CreateUserInput(
    val name: String,
    val email: String,
    val password: String
)