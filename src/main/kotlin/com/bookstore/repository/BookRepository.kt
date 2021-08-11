package com.bookstore.repository

import com.bookstore.enums.BookStatus
import com.bookstore.model.BookModel
import com.bookstore.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<BookModel, Int> {
    abstract fun findByStatus(status: BookStatus): List<BookModel>
}