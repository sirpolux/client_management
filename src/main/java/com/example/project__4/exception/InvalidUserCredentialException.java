package com.example.project__4.exception;

public class InvalidUserCredentialException extends RuntimeException{
    public  InvalidUserCredentialException(String message){
        super(message);
    }
}
