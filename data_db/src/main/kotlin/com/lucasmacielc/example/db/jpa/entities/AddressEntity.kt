package com.lucasmacielc.example.db.jpa.entities

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "customer_address")
data class AddressEntity(
        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(
                name = "UUID",
                strategy = "org.hibernate.id.UUIDGenerator")
        @Column(name = "id", updatable = false, nullable = false)
        val id: String? = "",
        val street: String,
        val neighborhood: String,
        val city: String,
        val state: String,
        val addressNumber: Int,
        val complement: String?,
        val zipCode: String) {

    @OneToOne(mappedBy = "address")
    val customer: CustomerEntity? = null

    @Column
    @CreationTimestamp
    val createdAt: Long? = null
}