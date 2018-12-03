package com.lucasmacielc.example.db.mappers

import com.lucasmacielc.example.db.jpa.entities.AddressEntity
import com.lucasmacielc.example.entities.Address

fun AddressEntity.toAddress() =
        Address(
                street = this.street,
                neighborhood = this.neighborhood,
                city = this.city,
                state = this.state,
                number = this.addressNumber,
                complement = this.complement,
                zipCode = this.zipCode
        )

fun Address.toAddressEntity() =
        AddressEntity(
                street = this.street!!,
                neighborhood = this.neighborhood!!,
                city = this.city!!,
                state = this.state!!,
                addressNumber = this.number!!,
                complement = this.complement,
                zipCode = this.zipCode!!
        )