package br.dev.io.kb_api_kotlin.presentation.controller

import br.dev.io.kb_api_kotlin.application.usecases.CreateUserUseCase
import br.dev.io.kb_api_kotlin.application.usecases.GetUsersUseCase
import br.dev.io.kb_api_kotlin.presentation.dto.CreateUserInput
import br.dev.io.kb_api_kotlin.presentation.dto.UserResponse
import br.dev.io.kb_api_kotlin.presentation.mapper.UserMapper
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class UserGraphQLController(
    private val getUsersUseCase: GetUsersUseCase,
    private val createUserUseCase: CreateUserUseCase,
    private val userMapper: UserMapper
) {

    @QueryMapping
    fun users(): List<UserResponse> =
        getUsersUseCase.execute().map(userMapper::toResponse)

    @QueryMapping
    fun user(@Argument id: Long): UserResponse? =
        getUsersUseCase.execute()
            .firstOrNull { it.id == id }
            ?.let(userMapper::toResponse)

    @MutationMapping
    fun createUser(@Argument input: CreateUserInput): UserResponse {
        val userInput = userMapper.toUserInput(input)
        val created = createUserUseCase.execute(userInput)
        return userMapper.toResponse(created)
    }
}
