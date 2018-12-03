package com.lucasmacielc.example.delivery.rest.imp

import com.lucasmacielc.example.delivery.rest.api.cutomer.CustomerDto
import com.lucasmacielc.example.delivery.rest.api.cutomer.CustomersResource
import com.lucasmacielc.example.delivery.rest.api.cutomer.toCustomer
import com.lucasmacielc.example.usecases.core.UseCaseExecutor
import com.lucasmacielc.example.usecases.core.customer.CreateCustomerUseCase
import com.lucasmacielc.example.usecases.core.customer.DeleteCustomerUseCase
import com.lucasmacielc.example.usecases.core.customer.GetCustomerByIdUseCase
import com.lucasmacielc.example.usecases.core.customer.ListCustomersUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import java.util.concurrent.CompletionStage

class CustomerResourceImp(private val useCaseExecutor: UseCaseExecutor,
                          private val createCustomerUseCase: CreateCustomerUseCase,
                          private val deleteCustomerUseCase: DeleteCustomerUseCase,
                          private val customerByIdUseCase: GetCustomerByIdUseCase,
                          private val listCustomersUseCase: ListCustomersUseCase) : CustomersResource {

    override fun getCustomerById(id: String): CompletionStage<CustomerDto> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createCustomer(@RequestBody customerDto: CustomerDto) = useCaseExecutor(
            useCase = createCustomerUseCase,
            requestDto = customerDto,
            requestConverter = { it.toCustomer() },
            responseConverter = { ResponseEntity<Unit>(HttpStatus.CREATED) })

    override fun updateCustomer(customerDto: CustomerDto): CompletionStage<ResponseEntity<Unit>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun listCustomers(): CompletionStage<List<CustomerDto>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteCustomer(id: String): CompletionStage<ResponseEntity<Unit>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
