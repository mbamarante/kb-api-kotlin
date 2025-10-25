package br.dev.io.kb_api_kotlin.infrastructure.security

import br.dev.io.kb_api_kotlin.application.ports.PasswordHasher
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class BcryptPasswordHasher(
    private val encoder: PasswordEncoder
) : PasswordHasher {
    override fun hash(raw: String): String = encoder.encode(raw)
    override fun matches(raw: String, hashed: String): Boolean = encoder.matches(raw, hashed)
}
