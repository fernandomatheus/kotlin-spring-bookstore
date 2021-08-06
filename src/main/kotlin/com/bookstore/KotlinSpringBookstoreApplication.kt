package com.bookstore

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinSpringBookstoreApplication

fun main(args: Array<String>) {
	runApplication<KotlinSpringBookstoreApplication>(*args)
}
