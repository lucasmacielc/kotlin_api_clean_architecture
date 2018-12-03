package com.lucasmacielc.example.db.jpa.entities

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "customer")
data class CustomerEntity(
        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(
                name = "UUID",
                strategy = "org.hibernate.id.UUIDGenerator")
        @Column(name = "id", updatable = false, nullable = false)
        val id: String?,
        val name: String,
        val dateOfBirthday: Long?,
        val document: String?,
        val phone: String?,
        val email: String,
        val notes: String?,
        @OneToOne(cascade = [CascadeType.ALL])
        @JoinColumn(name = "customer_address_id")
        val address: AddressEntity?) {

    @Column
    @CreationTimestamp
    val createdAt: Long? = null
}