package br.dev.io.kb_api_kotlin.infrastructure.config

import br.dev.io.kb_api_kotlin.application.ports.PasswordHasher
import br.dev.io.kb_api_kotlin.application.usecases.CreateUserUseCase
import br.dev.io.kb_api_kotlin.application.usecases.GetUsersUseCase
import br.dev.io.kb_api_kotlin.domain.repository.UserRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApplicationConfig {

    @Bean
    fun getUsersUseCase(userRepository: UserRepository) =
        GetUsersUseCase(userRepository)

    @Bean
    fun createUserUseCase(
        userRepository: UserRepository,
        passwordHasher: PasswordHasher
    ) = CreateUserUseCase(userRepository, passwordHasher)
}
