package com.example.project__4.exception;

public class UserAlredyExistsException extends  RuntimeException{
    public  UserAlredyExistsException(String message){
        super(message);
    }
}
