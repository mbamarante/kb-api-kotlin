// Infrastructure
plugins {
    kotlin("jvm")
    kotlin("plugin.spring") version "2.0.21"
    id("io.spring.dependency-management") version "1.1.7"
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":application"))

    // --- Spring Data JPA ---
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // --- PostgreSQL driver ---
    runtimeOnly("org.postgresql:postgresql")

    // --- Flyway Migration ---
    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-database-postgresql")

    // --- Coroutines Kotlin ---
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.8.1")

    // --- Spring Core ---
    implementation("org.springframework:spring-context")

    // --- Testes ---
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

dependencyManagement {
    imports {
        // 🧩 Herda as versões do Spring Boot
        mavenBom("org.springframework.boot:spring-boot-dependencies:3.5.7")
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

// 🚫 Garante que não tente gerar um bootJar (não é executável)
tasks.matching { it.name == "bootJar" }.configureEach {
    enabled = false
}

// ✅ Garante que gere um jar normal
tasks.matching { it.name == "jar" }.configureEach {
    enabled = true
}
