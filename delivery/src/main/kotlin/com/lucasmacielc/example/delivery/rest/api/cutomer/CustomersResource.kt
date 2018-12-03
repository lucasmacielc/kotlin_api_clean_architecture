package com.lucasmacielc.example.delivery.rest.api.cutomer

import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.concurrent.CompletionStage

@RestController
@RequestMapping("/customers")
interface CustomersResource {

    @GetMapping("/{id}", produces = ["application/json"], consumes = ["application/json"])
    fun getCustomerById(@PathVariable("id") id: String): CompletionStage<CustomerDto>

    @PostMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE])
    fun createCustomer(@RequestBody customerDto: CustomerDto): CompletionStage<ResponseEntity<Unit>>

    @PutMapping(produces = ["application/json"], consumes = ["application/json"])
    fun updateCustomer(@RequestBody customerDto: CustomerDto): CompletionStage<ResponseEntity<Unit>>

    @GetMapping(produces = ["application/json"], consumes = ["application/json"])
    fun listCustomers(): CompletionStage<List<CustomerDto>>

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable("id") id: String): CompletionStage<ResponseEntity<Unit>>
}