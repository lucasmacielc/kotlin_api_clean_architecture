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
        @Column(name = "value", updatable = false, nullable = false)
        val id: String?,
        val name: String,
        val dateOfBirthday: Long?,
        val document: String?,
        val phone: String?,
        val email: String,
        val notes: String?) {

    @Column
    @CreationTimestamp
    val createdAt: Long? = null
}