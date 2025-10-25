package br.dev.io.kb_api_kotlin.presentation.mapper

import br.dev.io.kb_api_kotlin.application.dto.UserInput
import br.dev.io.kb_api_kotlin.application.dto.UserOutput
import br.dev.io.kb_api_kotlin.presentation.dto.CreateUserInput
import br.dev.io.kb_api_kotlin.presentation.dto.UserRequest
import br.dev.io.kb_api_kotlin.presentation.dto.UserResponse
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface UserMapper {
    // assinaturas devem corresponder exatamente ao que o MapStruct gera (mesmo pacote/nome/tipos)
    fun toInput(request: UserRequest): UserInput
    fun toUserInput(input: CreateUserInput): UserInput
    fun toResponse(output: UserOutput): UserResponse
}
