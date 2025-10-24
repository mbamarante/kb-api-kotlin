package br.dev.io.kb_api_kotlin

import com.tngtech.archunit.core.domain.JavaClasses
import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.library.Architectures
import org.junit.jupiter.api.Test

class ArchitectureTest {

    private val importedClasses: JavaClasses = ClassFileImporter()
        .importPackages("br.dev.io.kb_api_kotlin")

    @Test
    fun `camadas devem respeitar a Clean Architecture`() {
        val rule = Architectures.layeredArchitecture()
            .consideringAllDependencies()

            .layer("Domain").definedBy("..domain..")
            .layer("Application").definedBy("..application..")
            .layer("Presentation").definedBy("..presentation..")
            .layer("Infrastructure").definedBy("..infrastructure..")

            // regras de direção de dependência
            .whereLayer("Application").mayOnlyBeAccessedByLayers("Presentation", "Infrastructure")
            .whereLayer("Domain").mayOnlyBeAccessedByLayers("Application", "Infrastructure")
            .whereLayer("Presentation").mayNotBeAccessedByAnyLayer()
            .whereLayer("Infrastructure").mayNotBeAccessedByAnyLayer()

        rule.check(importedClasses)
    }
}
