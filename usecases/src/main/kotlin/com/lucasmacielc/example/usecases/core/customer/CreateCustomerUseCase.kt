package com.lucasmacielc.example.usecases.core.customer

import com.lucasmacielc.example.entities.Customer
import com.lucasmacielc.example.usecases.core.UseCase
import com.lucasmacielc.example.usecases.core.exception.ValidationException
import com.lucasmacielc.example.usecases.core.gateway.CustomerRepository

class CreateCustomerUseCase(private val customerRepository: CustomerRepository) : UseCase<Customer, Unit> {

    override fun execute(request: Customer) {
        print(request.toString())
        if (request.name.isNullOrEmpty())
            throw ValidationException("Customer name should not be empty")
        if (request.email.isNullOrEmpty())
            throw ValidationException("Customer email should not be empty")

        customerRepository.save(request)
    }
}