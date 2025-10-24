// 🔧 Application
plugins {
    kotlin("jvm")
    kotlin("plugin.spring") version "2.0.21"
    id("io.spring.dependency-management") version "1.1.7"
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

dependencies {
    implementation(project(":domain"))

    // --- Spring Core ---
    implementation("org.springframework.boot:spring-boot-starter")

    // --- Corrotinas Kotlin ---
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")

    // --- Testes ---
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

dependencyManagement {
    imports {
        // 🧩 Herda as versões oficiais do Spring Boot
        mavenBom("org.springframework.boot:spring-boot-dependencies:3.5.7")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

// ✅ Garante que o jar padrão seja gerado
tasks.matching { it.name == "jar" }.configureEach {
    enabled = true
}
