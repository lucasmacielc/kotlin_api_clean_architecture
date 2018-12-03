package com.lucasmacielc.example.delivery.config

import com.lucasmacielc.example.usecases.core.UseCaseExecutorImp
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppModule {

    @Bean
    fun useCaseExecutor() = UseCaseExecutorImp()

}