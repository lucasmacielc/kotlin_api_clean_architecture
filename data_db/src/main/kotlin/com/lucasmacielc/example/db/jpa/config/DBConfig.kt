package com.lucasmacielc.example.db.jpa.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EntityScan(basePackages = ["com.lucasmacielc.example.db.jpa.entities"])
@EnableJpaRepositories(basePackages = ["com.lucasmacielc.example.db.jpa.repositories"])
class DBConfig