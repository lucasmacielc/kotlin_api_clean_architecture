package com.lucasmacielc.example.entities

import java.math.BigDecimal
import java.time.LocalDateTime

data class Payment(val value: BigDecimal,
                   val type: PaymentType,
                   val dueDate: LocalDateTime)

enum class PaymentType {
    CASH,
    TIMES
}