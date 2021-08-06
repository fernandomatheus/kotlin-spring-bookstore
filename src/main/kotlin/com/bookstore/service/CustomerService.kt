package com.bookstore.service

import com.bookstore.controller.request.PostCustomerRequest
import com.bookstore.controller.request.PutCustomerRequest
import com.bookstore.model.CustomerModel
import org.springframework.stereotype.Service

@Service
class CustomerService {
    val customers = mutableListOf<CustomerModel>()

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customers.filter{it.name.contains(name, ignoreCase = true)}
        }
        return customers
    }

    fun getCustomer(id: String): CustomerModel {
        return customers.filter { it.id == id }.first()
    }

    fun update(id: String, customer: PutCustomerRequest) {
        val(name, email) = customer
        customers.filter { it.id == id }.first().let {
            it.name = name
            it.email = email
        }
    }

    fun create(customer: PostCustomerRequest) {
        val (name, email) = customer
        val id = if(customers.isEmpty()) "1" else (customers.last().id.toInt() + 1).toString()
        customers.add(CustomerModel(id, name, email))
    }

    fun delete(id: String) {
        customers.removeIf { it.id == id }
    }
}