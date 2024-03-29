package com.bookstore.service

import com.bookstore.enums.BookStatus
import com.bookstore.enums.Errors
import com.bookstore.exception.NotFoundException
import com.bookstore.model.BookModel
import com.bookstore.model.CustomerModel
import com.bookstore.repository.BookRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository
) {
    fun create(book: BookModel) =
        bookRepository.save(book)


    fun findAll(pageable: Pageable): Page<BookModel> =
        bookRepository.findAll(pageable)


    fun findActives(pageable: Pageable): Page<BookModel> =
        bookRepository.findByStatus(BookStatus.ACTIVE, pageable)


    fun findById(id: Int): BookModel =
        bookRepository.findById(id).orElseThrow {
            NotFoundException(Errors.KSB100.message.format(id), Errors.KSB100.code)
        }


    fun delete(id: Int) {
        val book = findById(id)
        book.status = BookStatus.CANCELED
        update(book)
    }

    fun update(book: BookModel) {
        bookRepository.save(book)
    }

    fun deleteByCustomer(customer: CustomerModel) {
        val books = bookRepository.findByCustomer(customer)
        for(book in books) {
            book.status = BookStatus.DELETED
        }
        bookRepository.saveAll(books)
    }

    fun findAllById(bookIds: Set<Int>): List<BookModel> {
        return bookRepository.findAllById(bookIds).toList()
    }

}
