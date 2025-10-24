package br.dev.io.kb_api_kotlin.presentation.mapper

import br.dev.io.kb_api_kotlin.application.dto.*
import br.dev.io.kb_api_kotlin.presentation.dto.*

object UserMapper {
    fun UserOutput.toResponse() = UserResponse(id, name, email)
    fun UserRequest.toInput() = UserInput(name, email)
}