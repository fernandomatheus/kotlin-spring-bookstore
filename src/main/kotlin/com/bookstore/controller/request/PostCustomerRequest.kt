package com.bookstore.controller.request

import com.bookstore.validation.EmailAvailable
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class PostCustomerRequest (
    @field:NotEmpty(message = "Name should not be empty")
    var name: String,

    @field:Email(message = "E-mail not valid")
    @EmailAvailable
    var email: String
)