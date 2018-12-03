package com.lucasmacielc.example.delivery.rest.api.cutomer

data class AddressDto(val street: String?,
                      val neighborhood: String?,
                      val city: String?,
                      val state: String?,
                      val number: Int?,
                      val complement: String? = null,
                      val zipCode: String?)