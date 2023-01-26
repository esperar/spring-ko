package esperer.kopring.global.error.handler

import esperer.kopring.global.error.exception.BusinessException
import esperer.kopring.global.error.response.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(e: BusinessException): ResponseEntity<ErrorResponse> {
        return ResponseEntity(
            ErrorResponse(e.errorCode.message,e.errorCode.status),
            HttpStatus.valueOf(e.errorCode.status)
        )
    }
}