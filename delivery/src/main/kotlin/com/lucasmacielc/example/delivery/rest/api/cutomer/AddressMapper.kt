package com.lucasmacielc.example.delivery.rest.api.cutomer

import com.lucasmacielc.example.entities.Address

fun AddressDto.toAddress() =
        Address(
                street = this.street,
                neighborhood = this.neighborhood,
                city = this.city,
                state = this.state,
                number = this.number,
                complement = this.complement,
                zipCode = this.zipCode
        )

fun Address.toAddressDto() =
        AddressDto(
                street = this.street,
                neighborhood = this.neighborhood,
                city = this.city,
                state = this.state,
                number = this.number,
                complement = this.complement,
                zipCode = this.zipCode
        )