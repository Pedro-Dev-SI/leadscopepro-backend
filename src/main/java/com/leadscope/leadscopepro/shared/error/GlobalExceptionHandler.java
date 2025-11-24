package com.leadscope.leadscopepro.shared.error;

import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

// Tratador global de exceções: padroniza respostas de erro em JSON.
// Evita duplicação de try/catch nos controllers.
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Erros de domínio com code padronizado
    @ExceptionHandler(DomainException.class)
    public ResponseEntity<?> handleDomain(DomainException ex) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(new Problem(ex.code(), ex.getMessage()));
    }

    // Bean Validation nos DTOs
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidation(MethodArgumentNotValidException ex) {
        var msg = ex.getBindingResult().getFieldErrors().stream()
                .map(fe -> fe.getField() + ": " + fe.getDefaultMessage())
                .findFirst().orElse("Dados inválidos");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new Problem("request.invalid", msg));
    }

    // IllegalArgument “vazando” de VOs
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(new Problem("validation.error", ex.getMessage()));
    }

    // "Contrato" de erro simples e legível para o cliente
    public record Problem(String code, String detail) {}
}
