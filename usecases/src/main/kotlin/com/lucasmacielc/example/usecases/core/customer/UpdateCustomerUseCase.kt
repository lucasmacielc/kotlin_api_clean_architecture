package com.lucasmacielc.example.usecases.core.customer

import com.lucasmacielc.example.entities.Customer
import com.lucasmacielc.example.usecases.core.UseCase
import com.lucasmacielc.example.usecases.core.exception.NotFoundException
import com.lucasmacielc.example.usecases.core.exception.ValidationException
import com.lucasmacielc.example.usecases.core.gateway.CustomerRepository


class UpdateCustomerUseCase(private val customerRepository: CustomerRepository) : UseCase<Customer, Unit> {

    override fun execute(request: Customer) {
        if (request.id.isNullOrEmpty())
            throw ValidationException("Customer not found")
        if (!customerRepository.existsCustomerId(request.id!!))
            throw NotFoundException("Customer with value: ${request.id} not found")
        if (request.name.isNullOrEmpty())
            throw ValidationException("Customer name should not be empty")
        if (request.email.isNullOrEmpty())
            throw ValidationException("Customer email should not be empty")

        customerRepository.save(request)
    }
}