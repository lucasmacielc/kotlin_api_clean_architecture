package com.lucasmacielc.example.db.jpa.entities

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "address")
data class AddressEntity(
        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(
                name = "UUID",
                strategy = "org.hibernate.id.UUIDGenerator")
        @Column(name = "value", updatable = false, nullable = false)
        val id: String? = "",
        val street: String,
        val neighborhood: String,
        val city: String,
        val state: String,
        val addressNumber: Int,
        val complement: String?,
        val zipCode: String) {

    @Column
    @CreationTimestamp
    val createdAt: Long? = null
}