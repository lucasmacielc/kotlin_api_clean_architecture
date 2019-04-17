package com.lucasmacielc.example.delivery.rest.api.cutomer

import com.lucasmacielc.example.entities.Customer
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun Customer.toCustomerDto() =
        CustomerDto(
                id = this.id,
                name = this.name,
                dateOfBirthday = this.dateOfBirthday?.format(DateTimeFormatter.ISO_DATE),
                document = this.document,
                phone = this.phone,
                email = this.email,
                notes = this.notes
        )

fun CustomerDto.toCustomer() =
        Customer(
                id = this.id,
                name = this.name,
                dateOfBirthday = if (this.dateOfBirthday == null) null else LocalDateTime.from(DateTimeFormatter.ISO_DATE_TIME.parse(this.dateOfBirthday)),
                document = this.document,
                phone = this.phone,
                email = this.email,
                notes = this.notes
        )
