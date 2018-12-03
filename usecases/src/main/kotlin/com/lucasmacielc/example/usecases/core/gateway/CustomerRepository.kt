package com.lucasmacielc.example.usecases.core.gateway

import com.lucasmacielc.example.entities.Customer

interface CustomerRepository {

    fun save(customer: Customer)

    fun existsCustomerId(customerId: String): Boolean

    fun getCustomerById(id: String): Customer?

    fun deleteCustomerById(customerId: String)

    fun getAllCustomers(): List<Customer?>?
}