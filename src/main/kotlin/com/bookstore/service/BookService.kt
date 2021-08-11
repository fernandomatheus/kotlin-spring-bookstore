package com.bookstore.service

import com.bookstore.enums.BookStatus
import com.bookstore.model.BookModel
import com.bookstore.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository
) {
    fun create(book: BookModel) =
        bookRepository.save(book)


    fun findAll(): List<BookModel> =
        bookRepository.findAll().toList()


    fun findActives(): List<BookModel> =
        bookRepository.findByStatus(BookStatus.ACTIVE)


    fun findById(id: Int): BookModel =
        bookRepository.findById(id).orElseThrow()


    fun delete(id: Int) {
        val book = findById(id)
        book.status = BookStatus.CANCELED
        update(book)
    }

    fun update(book: BookModel) {
        bookRepository.save(book)
    }

}
