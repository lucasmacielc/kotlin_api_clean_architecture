package com.lucasmacielc.example.entities

sealed class Discount(val rate: Double)

class PercentDiscount(rate: Double) : Discount(rate)

class ValueDiscount(rate: Double) : Discount(rate)