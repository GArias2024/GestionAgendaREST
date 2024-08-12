package com.contact.manag.agenda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.contact.manag.agenda.constants.Constants;

@ControllerAdvice
public class GlobalExceptionHandler {

    // 409
    @ExceptionHandler(ContactoExistenteException.class)
    public ResponseEntity<ResponseError> handleContactoExistenteException(ContactoExistenteException ex) {
        ResponseError errorResponse = new ResponseError(ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    // 404
    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public ResponseEntity<ResponseError> handleNotFoundException(NotFoundException ex) {
        ResponseError errorResponse = new ResponseError(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    // 404
    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseBody
    public ResponseEntity<ResponseError> handleNoResourceFoundException(NoResourceFoundException ex) {
        ResponseError errorResponse = new ResponseError(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    // 429
    @ExceptionHandler(ManyResultsException.class)
    @ResponseBody
    public ResponseEntity<ResponseError> handleManyResultsException(ManyResultsException ex) {
        ResponseError errorResponse = new ResponseError(ex.getMessage());
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body(errorResponse);
    }

    // 400 personalizado
    @ExceptionHandler(BadFieldRequestException.class)
    @ResponseBody
    public ResponseEntity<ResponseError> handleBadFieldRequestException(BadFieldRequestException ex) {
        ResponseError errorResponse = new ResponseError(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    // 400 general
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public ResponseEntity<ResponseError> handleIllegalArgumentException() {
        ResponseError errorResponse = new ResponseError(Constants.ERROR_BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    // 400 validations
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<ResponseError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        StringBuilder fieldNames = new StringBuilder();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            if (error instanceof FieldError) {
                String fieldName = ((FieldError) error).getField();
                fieldNames.append(fieldName).append(", ");
            }
        });

        if (fieldNames.length() > 0) {
            fieldNames.setLength(fieldNames.length() - 2);
        }
        ResponseError errorResponse = new ResponseError(
                Constants.ERROR_BAD_REQUEST + " - campo: " + fieldNames);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    // 400 en body
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResponseEntity<ResponseError> handleHttpMessageNotReadableException() {
        ResponseError errorResponse = new ResponseError(Constants.ERROR_BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    // 500
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseError handleServerErrorException(Exception ex) {
        return new ResponseError("Error indeterminado en el servidor");
    }

}
