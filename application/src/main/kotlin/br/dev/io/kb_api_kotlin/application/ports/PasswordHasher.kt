package br.dev.io.kb_api_kotlin.application.ports

interface PasswordHasher {
    fun hash(raw: String): String
    fun matches(raw: String, hashed: String): Boolean
}