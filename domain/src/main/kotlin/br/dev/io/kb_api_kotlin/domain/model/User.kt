package br.dev.io.kb_api_kotlin.domain.model

data class User(
    val id: Long? = null,
    val name: String,
    val email: String
) {
    init {
        require(name.isNotBlank()) { "Name cannot be blank" }
        require(email.matches(Regex("^[A-Za-z0-9+_.-]+@(.+)$"))) {
            "Invalid email format"
        }
    }

    fun updateEmail(newEmail: String): User {
        return copy(email = newEmail)
    }
}