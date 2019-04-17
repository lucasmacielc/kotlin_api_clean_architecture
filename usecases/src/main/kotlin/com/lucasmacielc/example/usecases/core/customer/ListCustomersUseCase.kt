package com.lucasmacielc.example.usecases.core.customer

import com.lucasmacielc.example.entities.Customer
import com.lucasmacielc.example.usecases.core.UseCase
import com.lucasmacielc.example.usecases.core.gateway.CustomerRepository

class ListCustomersUseCase(private val customerRepository: CustomerRepository):
        UseCase<Unit, List<Customer>> {

    override fun execute(request: Unit): List<Customer> {
        return customerRepository.getAllCustomers().orEmpty()
    }
}