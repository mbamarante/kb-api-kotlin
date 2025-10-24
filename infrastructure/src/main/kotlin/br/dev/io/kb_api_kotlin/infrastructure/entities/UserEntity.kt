package br.dev.io.kb_api_kotlin.infrastructure.entities

import br.dev.io.kb_api_kotlin.domain.model.User
import jakarta.persistence.*

@Entity
@Table(name = "users")
open class UserEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long? = null

    @Column(nullable = false)
    open var name: String = ""

    @Column(nullable = false, unique = true)
    open var email: String = ""

    @Column(nullable = false)
    open var password: String = ""

    // --- Construtor secundário para conveniência ---
    constructor(id: Long?, name: String, email: String) : this() {
        this.id = id
        this.name = name
        this.email = email
    }

    fun toDomain(): User = User(
        id = id,
        name = name,
        email = email,
        password = "" // Password is not stored in the entity for security reasons
    )

    companion object {
        fun fromDomain(user: User): UserEntity =
            UserEntity(user.id, user.name, user.email)
    }
}
