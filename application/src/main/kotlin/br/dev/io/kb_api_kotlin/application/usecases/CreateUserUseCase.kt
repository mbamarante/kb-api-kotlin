package br.dev.io.kb_api_kotlin.application.usecases

import br.dev.io.kb_api_kotlin.application.dto.UserInput
import br.dev.io.kb_api_kotlin.application.dto.UserOutput
import br.dev.io.kb_api_kotlin.domain.repository.UserRepository
import br.dev.io.kb_api_kotlin.domain.model.User

class CreateUserUseCase(
    private val repository: UserRepository
) {
    fun execute(input: UserInput): UserOutput {
        val user = User(
            id = null,
            name = input.name,
            email = input.email
        )
        val saved = repository.save(user)
        return UserOutput(
            id = saved.id,
            name = saved.name,
            email = saved.email
        )
    }
}
