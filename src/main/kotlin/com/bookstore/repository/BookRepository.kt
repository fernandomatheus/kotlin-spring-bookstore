package com.bookstore.repository

import com.bookstore.enums.BookStatus
import com.bookstore.model.BookModel
import com.bookstore.model.CustomerModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface BookRepository : JpaRepository<BookModel, Int> {
    abstract fun findByStatus(status: BookStatus, pageable: Pageable): Page<BookModel>
    abstract fun findByCustomer(customer: CustomerModel): List<BookModel>

//    abstract fun findAll(pageable: Pageable): Page<BookModel>
}