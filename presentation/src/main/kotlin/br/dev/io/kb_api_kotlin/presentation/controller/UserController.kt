package br.dev.io.kb_api_kotlin.presentation

import br.dev.io.kb_api_kotlin.application.dto.*
import br.dev.io.kb_api_kotlin.application.usecases.*
import br.dev.io.kb_api_kotlin.presentation.dto.*
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/users")
class UserController(
    private val getUsersUseCase: GetUsersUseCase,
    private val createUserUseCase: CreateUserUseCase
) {
    @GetMapping
    fun getAll(): List<UserResponse> =
        getUsersUseCase.execute().map { it.toResponse() }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): UserResponse =
        getUsersUseCase.execute().firstOrNull { it.id == id }?.toResponse()
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!")

    @PostMapping
    fun create(@RequestBody request: UserRequest): UserResponse =
        createUserUseCase.execute(request.toInput()).toResponse()

    private fun UserOutput.toResponse() = UserResponse(id, name, email)
    private fun UserRequest.toInput() = UserInput(name, email)
}
