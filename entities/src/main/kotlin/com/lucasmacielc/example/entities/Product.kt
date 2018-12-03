package com.lucasmacielc.example.entities

import java.math.BigDecimal


data class Product(val name: String,
                   val value: BigDecimal,
                   val cost: BigDecimal,
                   val code: String,
                   val description: String)