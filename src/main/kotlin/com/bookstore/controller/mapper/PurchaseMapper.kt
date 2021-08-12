package com.bookstore.controller.mapper

import com.bookstore.controller.request.PostPurchaseRequest
import com.bookstore.model.PurchaseModel
import com.bookstore.service.BookService
import com.bookstore.service.CustomerService
import org.springframework.stereotype.Component

@Component
class PurchaseMapper(
    private val bookService: BookService,
    private val customerService: CustomerService
) {
    fun toModel(request: PostPurchaseRequest): PurchaseModel {
        val customer = customerService.getById(request.customerId)
        val books = bookService.findAllById(request.bookIds)

        return PurchaseModel(
            customer = customer,
            books = books,
            price = books.sumOf { it.price }
        )
    }
}