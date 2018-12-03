package com.lucasmacielc.example.delivery.rest.api.cutomer

data class CustomerDto(val id: String? = null,
                       val name: String? = null,
                       val dateOfBirthday: String? = null,
                       val document: String? = null,
                       val phone: String? = null,
                       val email: String?,
                       val notes: String? = null,
                       val address: AddressDto? = null)