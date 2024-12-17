package com.BQA.CAS.exception;

import com.BQA.CAS.common.response.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle generic exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CommonResponse<ErrorResponse>> handleException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error",
                System.currentTimeMillis()
        );
        CommonResponse response = new CommonResponse();
        response.setData(errorResponse);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Handle validation errors (e.g., @Valid)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CommonResponse<ErrorResponse>> handleValidationException(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .findFirst()
                .orElse("Validation error");
        ErrorResponse errorResponse = new ErrorResponse(
                errorMessage,
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                System.currentTimeMillis()
        );
        CommonResponse response = new CommonResponse();
        response.setData(errorResponse);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
