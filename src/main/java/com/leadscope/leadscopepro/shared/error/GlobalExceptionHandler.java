package com.leadscope.leadscopepro.shared.error;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

// Tratador global de exceções: padroniza respostas de erro em JSON.
// Evita duplicação de try/catch nos controllers.
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Exemplo: regra de negócio violada (e-mail duplicado) vira HTTP 422.
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(new Problem("validation_error", ex.getMessage()));
    }

    // "Contrato" de erro simples e legível para o cliente
    public record Problem(String code, String detail) {}
}
