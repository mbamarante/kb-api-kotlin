package br.dev.io.kb_api_kotlin.application.usecases

import br.dev.io.kb_api_kotlin.application.dto.UserOutput
import br.dev.io.kb_api_kotlin.domain.repository.UserRepository

class GetUsersUseCase(
    private val repository: UserRepository
) {
    fun execute(): List<UserOutput> =
        repository.findAll().map {
            UserOutput(it.id, it.name, it.email)
        }
}
