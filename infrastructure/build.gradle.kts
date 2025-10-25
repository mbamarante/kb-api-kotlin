plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
}

repositories { mavenCentral() }

dependencies {
    implementation(project(":domain"))
    implementation(project(":application"))

    // --- Spring Boot Starter ---
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.3.5")

    // --- Liquibase moderno ---
    implementation("org.liquibase:liquibase-core:4.29.2")

    // --- Database ---
    runtimeOnly("org.postgresql:postgresql")

    // BCryptPasswordEncoder e PasswordEncoder
    implementation("org.springframework.security:spring-security-crypto")
}
