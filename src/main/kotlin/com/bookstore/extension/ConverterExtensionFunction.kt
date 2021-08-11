package com.bookstore.extension

import com.bookstore.controller.request.PostCustomerRequest
import com.bookstore.controller.request.PutCustomerRequest
import com.bookstore.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel = CustomerModel(name = this.name, email = this.email)
fun PutCustomerRequest.toCustomerModel(id: Int): CustomerModel = CustomerModel(id = id, name = this.name, email = this.email)