package com.bookstore.extension

import com.bookstore.controller.request.PostBookRequest
import com.bookstore.controller.request.PostCustomerRequest
import com.bookstore.controller.request.PutBookRequest
import com.bookstore.controller.request.PutCustomerRequest
import com.bookstore.enums.BookStatus
import com.bookstore.model.BookModel
import com.bookstore.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel =
    CustomerModel(
        name = this.name,
        email = this.email
    )

fun PutCustomerRequest.toCustomerModel(id: Int): CustomerModel =
    CustomerModel(
        id = id,
        name = this.name,
        email = this.email
    )

fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel = BookModel(
    name = this.name,
    price = this.price,
    status = BookStatus.ACTIVE,
    customer = customer
)

fun PutBookRequest.toBookModel(previousValue: BookModel): BookModel = BookModel(
    id = previousValue.id,
    name = this.name ?: previousValue.name,
    price = this.price ?: previousValue.price,
    status = previousValue.status,
    customer = previousValue.customer
)