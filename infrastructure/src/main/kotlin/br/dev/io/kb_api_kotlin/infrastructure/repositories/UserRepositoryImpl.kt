package br.dev.io.kb_api_kotlin.infrastructure.repositories

import br.dev.io.kb_api_kotlin.domain.model.User
import br.dev.io.kb_api_kotlin.domain.repository.UserRepository
import br.dev.io.kb_api_kotlin.infrastructure.entities.UserEntity
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    private val jpaRepo: UserJpaRepository
) : UserRepository {

    override fun findAll(): List<User> =
        jpaRepo.findAll().map { it.toDomain() }

    override fun save(user: User): User =
        jpaRepo.save(UserEntity.fromDomain(user)).toDomain()
}
