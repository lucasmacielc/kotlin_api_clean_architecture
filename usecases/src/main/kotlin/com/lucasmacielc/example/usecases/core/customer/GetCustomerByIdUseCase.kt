package com.lucasmacielc.example.usecases.core.customer

import com.lucasmacielc.example.entities.Customer
import com.lucasmacielc.example.entities.CustomerId
import com.lucasmacielc.example.usecases.core.UseCase
import com.lucasmacielc.example.usecases.core.exception.NotFoundException
import com.lucasmacielc.example.usecases.core.gateway.CustomerRepository

class GetCustomerByIdUseCase(private val customerRepository: CustomerRepository) :
        UseCase<CustomerId, Customer> {
    override fun execute(customerId: CustomerId) =
            customerRepository.getCustomerByCustomerCode(customerId) ?: throw NotFoundException("No customer for value: ${customerId.value}")

}