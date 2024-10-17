package com.example.project__4.exception;


import com.example.project__4.constant.ErrorCodes;
import com.example.project__4.utils.ResponseWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

@ControllerAdvice
@RequiredArgsConstructor
public class ApplicationExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public final ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex){
        List<String> errors = List.of(ex.getMessage());
        return new ResponseEntity<>(new ErrorResponse(errors, ErrorCodes.ENTITY_NOT_FOUND_ERROR),HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(InvalidUserCredentialException.class)
    public final  ResponseEntity<Object> handleInvalidUserCredentialException(InvalidUserCredentialException ex){
        List<String> errors = List.of(ex.getMessage());
        return new ResponseEntity<>(new ErrorResponse(errors, ErrorCodes.INVALID_LOGIN_CREDENTIALS),HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(UserAlredyExistsException.class)
    public final  ResponseEntity<Object> handleUserAlredyExistsException(UserAlredyExistsException ex){
        List<String> errors = List.of(ex.getMessage());
        return new ResponseEntity<>(new ErrorResponse(errors, ErrorCodes.USER_ALREADY_EXISTS),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public  final  ResponseEntity<Object> handleBadCredentialsException(BadCredentialsException ex){
        return  new ResponseEntity<>( new ErrorResponse(List.of(ex.getMessage()), ErrorCodes.INVALID_LOGIN_CREDENTIALS),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  final ResponseEntity<Object> MethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String,String> errors = new HashMap<>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error->{
                    errors.put(error.getField(), error.getDefaultMessage());
                });
        return  new ResponseEntity<>(errors ,HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(CustomRuntimeException.class)
    public  final  ResponseEntity<Object> handleCustomRuntimeException(CustomRuntimeException ex){
        return  new ResponseEntity<>( new ErrorResponse(List.of(ex.getMessage()), ErrorCodes.BAD_REQUEST),HttpStatus.BAD_REQUEST);
    }
}
