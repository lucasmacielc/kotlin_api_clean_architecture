package com.lucasmacielc.example.delivery

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = [
    "com.lucasmacielc.example.delivery.config",
    "com.lucasmacielc.example.db.jpa.config",
    "com.lucasmacielc.example.delivery.rest.imp"
])
class ExampleApplication

fun main(args: Array<String>) {
    runApplication<ExampleApplication>(*args)
}
