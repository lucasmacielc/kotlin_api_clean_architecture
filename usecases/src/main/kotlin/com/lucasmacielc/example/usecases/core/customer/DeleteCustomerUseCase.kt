package com.lucasmacielc.example.usecases.core.customer

import com.lucasmacielc.example.entities.CustomerId
import com.lucasmacielc.example.usecases.core.UseCase
import com.lucasmacielc.example.usecases.core.exception.NotFoundException
import com.lucasmacielc.example.usecases.core.gateway.CustomerRepository

class DeleteCustomerUseCase(private val customerRepository: CustomerRepository) :
        UseCase<CustomerId, Unit> {

    override fun execute(request: CustomerId) {
        if (!customerRepository.existsCustomerId(request.value))
            throw NotFoundException("No customer for value: ${request.value}")

        customerRepository.deleteCustomerByCustomerId(request)
    }

}