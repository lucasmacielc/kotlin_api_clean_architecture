package com.lucasmacielc.example.db.jpa.repositories.customer

import com.lucasmacielc.example.db.jpa.entities.CustomerEntity
import com.lucasmacielc.example.db.jpa.repositories.unwrap
import com.lucasmacielc.example.db.mappers.toCustomer
import com.lucasmacielc.example.db.mappers.toCustomerEntity
import com.lucasmacielc.example.entities.Customer
import com.lucasmacielc.example.usecases.core.gateway.CustomerRepository
import javax.transaction.Transactional

open class JpaCustomerRepository(private val dbCustomerRepository: DBCustomerRepository) : CustomerRepository {

    @Transactional
    override fun save(customer: Customer) {
        dbCustomerRepository.save(customer.toCustomerEntity())
    }

    override fun existsCustomerId(customerId: String) = dbCustomerRepository.existsById(customerId)

    override fun getCustomerById(id: String): Customer? = dbCustomerRepository.findById(id).unwrap(CustomerEntity::toCustomer)

    @Transactional
    override fun deleteCustomerById(customerId: String) {
        dbCustomerRepository.deleteById(customerId)
    }

    override fun getAllCustomers(): List<Customer?>? = dbCustomerRepository.findAll().map(CustomerEntity::toCustomer)
}