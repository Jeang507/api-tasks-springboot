package com.task.apitask.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(ApiException.class)
        public ResponseEntity<ErrorResponse> handlerApiException(ApiException ex){
                HttpStatus httpStatus = switch (ex.getCode()) {
                        case "RESOURCE_NOT_FOUND" -> HttpStatus.NOT_FOUND;
                        case "VALIDATION_ERROR" -> HttpStatus.BAD_REQUEST;
                        case "RESOURCE_CONFLICT" -> HttpStatus.CONFLICT;
                        case "OPERATION_NOT_ALLOWED" -> HttpStatus.FORBIDDEN;
                        default -> HttpStatus.INTERNAL_SERVER_ERROR;
                };

                return ResponseEntity.status(httpStatus).body(new ErrorResponse(ex.getCode(), ex.getDetail()));
        }

}
