package com.lucasmacielc.example.db.mappers

import com.lucasmacielc.example.db.jpa.entities.CustomerEntity
import com.lucasmacielc.example.entities.Customer
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

fun CustomerEntity.toCustomer() =
        Customer(
                id = this.id,
                name = this.name,
                dateOfBirthday = if (this.dateOfBirthday == null) null else LocalDateTime.ofInstant(Instant.ofEpochMilli(this.dateOfBirthday), ZoneId.systemDefault()),
                document = this.document,
                phone = this.phone,
                email = this.email,
                notes = this.notes)

fun Customer.toCustomerEntity() =
        CustomerEntity(
                id = this.id ?: "",
                name = this.name!!,
                dateOfBirthday = this.dateOfBirthday?.atZone(ZoneId.systemDefault())?.toInstant()?.toEpochMilli(),
                document = this.document,
                phone = this.phone,
                email = this.email!!,
                notes = this.notes
        )