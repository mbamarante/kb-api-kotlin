package br.dev.io.kb_api_kotlin.domain.repository

import br.dev.io.kb_api_kotlin.domain.model.User

interface UserRepository {
    fun findAll(): List<User>
    fun save(user: User): User
}
