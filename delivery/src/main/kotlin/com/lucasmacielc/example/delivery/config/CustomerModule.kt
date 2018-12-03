package com.lucasmacielc.example.delivery.config

import com.lucasmacielc.example.db.jpa.repositories.customer.DBCustomerRepository
import com.lucasmacielc.example.db.jpa.repositories.customer.JpaCustomerRepository
import com.lucasmacielc.example.delivery.rest.imp.CustomerResourceImp
import com.lucasmacielc.example.usecases.core.UseCaseExecutor
import com.lucasmacielc.example.usecases.core.UseCaseExecutorImp
import com.lucasmacielc.example.usecases.core.customer.CreateCustomerUseCase
import com.lucasmacielc.example.usecases.core.customer.DeleteCustomerUseCase
import com.lucasmacielc.example.usecases.core.customer.GetCustomerByIdUseCase
import com.lucasmacielc.example.usecases.core.customer.ListCustomersUseCase
import com.lucasmacielc.example.usecases.core.gateway.CustomerRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CustomerModule {

    @Bean
    fun customersResourceImp(
            useCaseExecutor: UseCaseExecutor,
            createCustomerUseCase: CreateCustomerUseCase,
            deleteCustomerUseCase: DeleteCustomerUseCase,
            getCustomerByIdUseCase: GetCustomerByIdUseCase,
            listCustomersUseCase: ListCustomersUseCase
    ) = CustomerResourceImp(useCaseExecutor,
            createCustomerUseCase,
            deleteCustomerUseCase,
            getCustomerByIdUseCase,
            listCustomersUseCase)

    @Bean
    fun getCustomerByIdUseCase(customerRepository: CustomerRepository) = GetCustomerByIdUseCase(customerRepository)

    @Bean
    fun createCustomerUseCase(customerRepository: CustomerRepository) = CreateCustomerUseCase(customerRepository)

    @Bean
    fun deleteCustomerUseCase(customerRepository: CustomerRepository) = DeleteCustomerUseCase(customerRepository)

    @Bean
    fun listCustomersUseCase(customerRepository: CustomerRepository) = ListCustomersUseCase(customerRepository)

    @Bean
    fun customerRepository(dbCustomerRepository: DBCustomerRepository) = JpaCustomerRepository(dbCustomerRepository)
}