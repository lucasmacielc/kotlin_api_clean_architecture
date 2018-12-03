package com.lucasmacielc.example.delivery.rest.imp

import com.lucasmacielc.example.delivery.rest.api.ErrorCodeDto
import com.lucasmacielc.example.delivery.rest.api.ErrorDto
import com.lucasmacielc.example.usecases.core.exception.NotFoundException
import com.lucasmacielc.example.usecases.core.exception.ValidationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
@RestController
class GlobalExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(NotFoundException::class)
    fun notFound(ex: NotFoundException) =
            ResponseEntity(ErrorDto(ErrorCodeDto.NOT_FOUND, "Resource not found"), HttpStatus.NOT_FOUND)

    @ExceptionHandler(ValidationException::class)
    fun alreadyExists(ex: ValidationException) =
            ResponseEntity(ErrorDto(ErrorCodeDto.VALIDATION_ERROR, ex.message), HttpStatus.BAD_REQUEST)
}
