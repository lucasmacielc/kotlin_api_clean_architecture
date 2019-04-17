package com.lucasmacielc.example.delivery.rest.imp

import com.lucasmacielc.example.delivery.rest.api.cutomer.CustomerDto
import com.lucasmacielc.example.delivery.rest.api.cutomer.CustomersResource
import com.lucasmacielc.example.delivery.rest.api.cutomer.toCustomer
import com.lucasmacielc.example.delivery.rest.api.cutomer.toCustomerDto
import com.lucasmacielc.example.entities.CustomerId
import com.lucasmacielc.example.usecases.core.UseCaseExecutor
import com.lucasmacielc.example.usecases.core.customer.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import java.util.concurrent.CompletionStage

class CustomerResourceImpl(private val useCaseExecutor: UseCaseExecutor,
                           private val createCustomerUseCase: CreateCustomerUseCase,
                           private val updateCustomerUseCase: UpdateCustomerUseCase,
                           private val deleteCustomerUseCase: DeleteCustomerUseCase,
                           private val customerByIdUseCase: GetCustomerByIdUseCase,
                           private val listCustomersUseCase: ListCustomersUseCase) : CustomersResource {

    override fun getCustomerById(@PathVariable("value") id: String): CompletionStage<CustomerDto> {
        return useCaseExecutor(
                useCase = customerByIdUseCase,
                requestDto = id,
                requestConverter = { CustomerId(id) },
                responseConverter = { it.toCustomerDto() }
        )
    }

    override fun createCustomer(@RequestBody customerDto: CustomerDto) = useCaseExecutor(
            useCase = createCustomerUseCase,
            requestDto = customerDto,
            requestConverter = { it.toCustomer() },
            responseConverter = { ResponseEntity<Unit>(HttpStatus.CREATED) }
    )

    override fun updateCustomer(@PathVariable("value") id: String,
                                @RequestBody customerDto: CustomerDto) = useCaseExecutor(
            useCase = updateCustomerUseCase,
            requestDto = customerDto.apply { this.id = id },
            requestConverter = { it.toCustomer() },
            responseConverter = { ResponseEntity<Unit>(HttpStatus.OK) }
    )

    override fun listCustomers(): CompletionStage<List<CustomerDto>> {
        return useCaseExecutor(
                useCase = listCustomersUseCase,
                responseConverter = { list -> list.map { it.toCustomerDto() } }
        )
    }

    override fun deleteCustomer(@PathVariable("value") id: String): CompletionStage<ResponseEntity<Unit>> {
        return useCaseExecutor(
                useCase = deleteCustomerUseCase,
                requestDto = id,
                requestConverter = { CustomerId(it) },
                responseConverter = { ResponseEntity<Unit>(HttpStatus.NO_CONTENT) }
        )
    }

}
