// presentation
plugins {
    id("org.springframework.boot")           // versão herdada do root
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("kapt")
}

group = "br.dev.io.presentation"
version = "0.0.1-SNAPSHOT"
description = "Kettleboard Presentation Module"

java {
    // 🔒 Garante que o Gradle compile apenas código Kotlin
    sourceSets["main"].java.setSrcDirs(listOf("src/main/kotlin"))
    sourceSets["test"].java.setSrcDirs(listOf("src/test/kotlin"))

    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // --- Internal modules ---
    implementation(project(":application"))
    implementation(project(":infrastructure"))
    implementation(project(":domain"))

    // --- Spring Core / Web ---
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-graphql")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    runtimeOnly("org.postgresql:postgresql")

    // --- Kotlin support ---
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

    // --- Coroutines / debug ---
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
    runtimeOnly("org.jetbrains.kotlinx:kotlinx-coroutines-debug:1.9.0")

    // --- MapStruct ---
    implementation("org.mapstruct:mapstruct:1.6.2")
    kapt("org.mapstruct:mapstruct-processor:1.6.2")
    kaptTest("org.mapstruct:mapstruct-processor:1.6.2")

    // --- Dev tools ---
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // --- Testes ---
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("org.springframework.graphql:spring-graphql-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // --- ArchUnit ---
    testImplementation("com.tngtech.archunit:archunit-junit5:1.3.0")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
    // 🚫 Evita erro de duplicata no JAR final
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    dependsOn("classes")
}

tasks.named("clean") {
    doLast {
        delete("build/classes/java", "build/classes/kotlin", "build/tmp")
    }
}
