package br.dev.io.kb_api_kotlin.infrastructure.repositories

import br.dev.io.kb_api_kotlin.infrastructure.entities.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserJpaRepository : JpaRepository<UserEntity, Long>
