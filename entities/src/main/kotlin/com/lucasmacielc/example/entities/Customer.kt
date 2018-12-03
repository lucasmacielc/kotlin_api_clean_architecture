package com.lucasmacielc.example.entities

import java.time.LocalDateTime

data class Customer(val id: String?,
                    val name: String?,
                    val dateOfBirthday: LocalDateTime?,
                    val document: String?,
                    val phone: String?,
                    val email: String?,
                    val notes: String?,
                    val address: Address?)