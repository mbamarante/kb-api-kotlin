package br.dev.io.kb_api_kotlin.application.usecases

import br.dev.io.kb_api_kotlin.application.dto.UserInput
import br.dev.io.kb_api_kotlin.application.dto.UserOutput
import br.dev.io.kb_api_kotlin.application.ports.PasswordHasher
import br.dev.io.kb_api_kotlin.domain.model.User
import br.dev.io.kb_api_kotlin.domain.repository.UserRepository

class CreateUserUseCase(
    private val repository: UserRepository,
    private val passwordHasher: PasswordHasher
) {
    fun execute(input: UserInput): UserOutput {
        val hashedPassword = passwordHasher.hash(input.password)

        val user = User(
            id = null,
            name = input.name,
            email = input.email,
            password = hashedPassword
        )

        val saved = repository.save(user)

        return UserOutput(
            id = saved.id,
            name = saved.name,
            email = saved.email
        )
    }
}
