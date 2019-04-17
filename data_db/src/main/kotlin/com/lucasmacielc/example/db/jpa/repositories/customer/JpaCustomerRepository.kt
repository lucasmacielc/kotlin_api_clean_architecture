package com.lucasmacielc.example.db.jpa.repositories.customer

import com.lucasmacielc.example.db.jpa.entities.CustomerEntity
import com.lucasmacielc.example.db.jpa.repositories.unwrap
import com.lucasmacielc.example.db.mappers.toCustomer
import com.lucasmacielc.example.db.mappers.toCustomerEntity
import com.lucasmacielc.example.entities.Customer
import com.lucasmacielc.example.entities.CustomerId
import com.lucasmacielc.example.usecases.core.gateway.CustomerRepository
import javax.transaction.Transactional

open class JpaCustomerRepository(private val dbCustomerRepository: DBCustomerRepository) : CustomerRepository {

    override fun getCustomerByCustomerCode(customerId: CustomerId): Customer? {
        return dbCustomerRepository.findById(customerId.value).unwrap(CustomerEntity::toCustomer)
    }

    @Transactional
    override fun save(customer: Customer) {
        dbCustomerRepository.save(customer.toCustomerEntity())
    }

    override fun existsCustomerId(customerId: String) = dbCustomerRepository.existsById(customerId)


    @Transactional
    override fun deleteCustomerByCustomerId(customerId: CustomerId) {
        dbCustomerRepository.deleteById(customerId.value)
    }

    override fun getAllCustomers(): List<Customer>? = dbCustomerRepository.findAll().map(CustomerEntity::toCustomer)
}