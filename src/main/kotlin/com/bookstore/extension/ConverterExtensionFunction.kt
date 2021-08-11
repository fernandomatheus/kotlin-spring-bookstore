package com.bookstore.extension

import com.bookstore.controller.request.PostBookRequest
import com.bookstore.controller.request.PostCustomerRequest
import com.bookstore.controller.request.PutBookRequest
import com.bookstore.controller.request.PutCustomerRequest
import com.bookstore.controller.response.BookResponse
import com.bookstore.controller.response.CustomerResponse
import com.bookstore.enums.BookStatus
import com.bookstore.enums.CustomerStatus
import com.bookstore.model.BookModel
import com.bookstore.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel =
    CustomerModel(
        name = this.name,
        email = this.email,
        status = CustomerStatus.ACTIVE
    )

fun PutCustomerRequest.toCustomerModel(previousValue: CustomerModel): CustomerModel =
    CustomerModel(
        id = previousValue.id,
        name = this.name,
        email = this.email,
        status = previousValue.status
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

fun CustomerModel.toResponse(): CustomerResponse = CustomerResponse(
        id = this.id,
        name = this.name,
        email = this.email,
        status = this.status
    )


fun BookModel.toResponse(): BookResponse = BookResponse(
    id = this.id,
    name = this.name,
    price = this.price,
    customer = this.customer,
    status = this.status
)