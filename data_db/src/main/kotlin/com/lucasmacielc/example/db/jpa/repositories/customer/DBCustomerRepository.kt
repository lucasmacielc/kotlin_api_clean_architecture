package com.lucasmacielc.example.db.jpa.repositories.customer

import com.lucasmacielc.example.db.jpa.entities.CustomerEntity
import org.springframework.data.jpa.repository.JpaRepository

interface DBCustomerRepository: JpaRepository<CustomerEntity, String>