package br.dev.io.kb_api_kotlin.infrastructure.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
class SecurityCryptoConfig {
    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder() // custo padrão 10
}