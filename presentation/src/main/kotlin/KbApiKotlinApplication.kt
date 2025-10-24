package br.dev.io.kb_api_kotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
    scanBasePackages = ["br.dev.io.kb_api_kotlin"]
)
class KbApiKotlinApplication

fun main(args: Array<String>) {
    runApplication<KbApiKotlinApplication>(*args)
}
