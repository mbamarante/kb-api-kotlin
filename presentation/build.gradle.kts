plugins {
    id("org.springframework.boot")           // versão vem do root
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("kapt")
}

group = "br.dev.io.presentation"
version = "0.0.1-SNAPSHOT"
description = "Kettleboard Presentation Module"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

dependencies {
    // --- internal modules ---
    implementation(project(":application"))
    implementation(project(":infrastructure"))
    implementation(project(":domain"))

    // --- Core & Web ---
//    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-graphql")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // --- Data (R2DBC) ---
//    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
//    runtimeOnly("org.postgresql:postgresql")
//    runtimeOnly("org.postgresql:r2dbc-postgresql")

    // jpa
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("org.postgresql:postgresql")

    // --- Kotlin ---
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

    // --- Testes ---
//    testImplementation("org.springframework.boot:spring-boot-starter-test") {
//        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
//    }

    testImplementation("io.projectreactor:reactor-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test")
    testImplementation("org.springframework.graphql:spring-graphql-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // dev
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // archunit
//    testImplementation("com.tngtech.archunit:archunit-junit5:1.3.0")
//    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.3")
//    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.3")

    // --- Testes com Spring Boot ---
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }

    // --- ArchUnit (opcional) ---
    testImplementation("com.tngtech.archunit:archunit-junit5:1.3.0")

    // ✅ MapStruct
    implementation("org.mapstruct:mapstruct:1.6.2")
    kapt("org.mapstruct:mapstruct-processor:1.6.2")

    // ✅ Necessário para integração com Spring
    kaptTest("org.mapstruct:mapstruct-processor:1.6.2")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
