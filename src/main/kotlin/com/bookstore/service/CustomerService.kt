package com.bookstore.service

import com.bookstore.controller.request.PostCustomerRequest
import com.bookstore.controller.request.PutCustomerRequest
import com.bookstore.enums.CustomerStatus
import com.bookstore.enums.Errors
import com.bookstore.exception.NotFoundException
import com.bookstore.model.CustomerModel
import com.bookstore.repository.CustomerRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class CustomerService(
    val customerRepository: CustomerRepository,
    val bookService: BookService
) {
    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContaining(it)
        }
        return customerRepository.findAll().toList()
    }

    fun getById(id: Int): CustomerModel {
        return customerRepository.findById(id).orElseThrow{
            NotFoundException(Errors.KSB0002.message.format(id), Errors.KSB0002.code)
        }
    }

    fun update(customer: CustomerModel) {
        if(!customerRepository.existsById(customer.id!!)) {
            throw Exception()
        }
        customerRepository.save(customer)
    }

    fun create(customer: CustomerModel) {
        customerRepository.save(customer)
    }

    fun delete(id: Int) {
        val customer = getById(id)
        bookService.deleteByCustomer(customer)

        customer.status = CustomerStatus.INACTIVE

        customerRepository.save(customer)
    }
}