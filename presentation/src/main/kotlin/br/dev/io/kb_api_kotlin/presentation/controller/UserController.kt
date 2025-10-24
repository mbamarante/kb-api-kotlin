package br.dev.io.kb_api_kotlin.presentation

import br.dev.io.kb_api_kotlin.application.usecases.CreateUserUseCase
import br.dev.io.kb_api_kotlin.application.usecases.GetUsersUseCase
import br.dev.io.kb_api_kotlin.presentation.dto.*
import br.dev.io.kb_api_kotlin.presentation.mapper.UserMapper
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/users")
class UserController(
    private val getUsersUseCase: GetUsersUseCase,
    private val createUserUseCase: CreateUserUseCase,
    private val userMapper: UserMapper
) {
    @GetMapping
    fun getAll(): List<UserResponse> =
        getUsersUseCase.execute().map(userMapper::toResponse)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): UserResponse =
        getUsersUseCase.execute().firstOrNull { it.id == id }
            ?.let(userMapper::toResponse)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!")

    @PostMapping
    fun create(@RequestBody request: UserRequest): UserResponse =
        userMapper.toResponse(createUserUseCase.execute(userMapper.toInput(request)))
}
