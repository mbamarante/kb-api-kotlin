// application/build.gradle.kts
plugins {
    kotlin("jvm")
    kotlin("kapt")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

dependencies {
    implementation(project(":domain"))

    implementation("com.tngtech.archunit:archunit-junit5:1.3.0")

    // MapStruct (se estiveres usando DTOs aqui)
    implementation("org.mapstruct:mapstruct:1.6.2")
    kapt("org.mapstruct:mapstruct-processor:1.6.2")
}
