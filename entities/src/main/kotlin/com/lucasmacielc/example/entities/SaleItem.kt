package com.lucasmacielc.example.entities

data class SaleItem(val product: Product,
                    val quantity: Double) {

    val value = product.value * quantity.toBigDecimal()
}
