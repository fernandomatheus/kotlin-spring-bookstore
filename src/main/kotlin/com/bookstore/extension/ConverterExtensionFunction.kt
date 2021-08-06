package com.bookstore.extension

import com.bookstore.controller.request.PostCustomerRequest
import com.bookstore.controller.request.PutCustomerRequest
import com.bookstore.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel = CustomerModel("1", this.name, this.email)
fun PutCustomerRequest.toCustomerModel(id: String): CustomerModel = CustomerModel(id, this.name, this.email)