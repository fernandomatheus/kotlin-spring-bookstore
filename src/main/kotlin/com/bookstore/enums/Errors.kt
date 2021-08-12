package com.bookstore.enums

enum class Errors(val code: String, val message: String) {
    KSB0001("KSB-0001", "Book %s do not exist"),
    KSB0002("KSB-0002", "Customer %s do not exist")
}