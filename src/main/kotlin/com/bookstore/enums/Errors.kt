package com.bookstore.enums

enum class Errors(val code: String, val message: String) {
    KSB001("KSB-0001", "Invalid Request"),
    //Book
    KSB100("KSB-100", "Book %s do not exist"),
    KSB101("KSB-101", "Cannot update book with status %s"),
    //Customer
    KSB200("KSB-200", "Customer %s do not exist")
}