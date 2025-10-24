package br.dev.io.kb_api_kotlin.presentation.mapper

import br.dev.io.kb_api_kotlin.application.dto.UserInput
import br.dev.io.kb_api_kotlin.application.dto.UserOutput
import br.dev.io.kb_api_kotlin.presentation.dto.UserRequest
import br.dev.io.kb_api_kotlin.presentation.dto.UserResponse
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface UserMapper {
    fun toInput(request: UserRequest): UserInput
    fun toResponse(output: UserOutput): UserResponse
}
