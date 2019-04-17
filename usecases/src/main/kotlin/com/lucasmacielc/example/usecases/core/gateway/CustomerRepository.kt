package com.lucasmacielc.example.usecases.core.gateway

import com.lucasmacielc.example.entities.Customer
import com.lucasmacielc.example.entities.CustomerId

interface CustomerRepository {

    fun save(customer: Customer)

    fun existsCustomerId(customerId: String): Boolean

    fun getCustomerByCustomerCode(customerId: CustomerId): Customer?

    fun deleteCustomerByCustomerId(customerId: CustomerId)

    fun getAllCustomers(): List<Customer>?
}