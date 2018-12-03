package com.lucasmacielc.example.entities

import java.time.LocalDateTime


data class Sale(val items: List<SaleItem>,
                val emission: LocalDateTime,
                val number: Number,
                val customer: Customer,
                val payment: Payment,
                val discount: Discount,
                val notes: String)