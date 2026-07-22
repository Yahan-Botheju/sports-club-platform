package lk.sportsclub.platform.shared.exceptions;

import lk.sportsclub.platform.shared.DTOs.ErrorDetail;
import org.springframework.boot.web.error.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.awt.*;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    //resource not found exception
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleNotFound(ResourceNotFoundException ex){
        ErrorDetail error = new ErrorDetail("NOT_FOUND", ex.getMessage(), LocalDateTime.now())
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.error(error));
    }

    //business rule validation handler
    @ExceptionHandler({
            InsufficientBalanceException.class,
            SlotAlreadyBookedException.class
    })
    public ResponseEntity<ApiResponse<Void>> handleBusinessConflict(DomainException ex){
        ErrorDetail error = new ErrorDetail("BUSSINESS_RULE_VALIDATION", ex.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ApiResponse.error(error));
    }

    //handle request validation
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> handleValidationErrors(MethodArgumentNotValidException ex){
        List<String> details = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .toList();

        ErrorDetail error = new ErrorDetail("VALIDATION_FAILED", details.toString(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.error(error));
    }

    //handle unexpected exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGenericException(Exception ex){
        ErrorDetail error = new ErrorDetail("INTERNAL_SERVER_ERROR", ex.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.error(error));
    }
}
