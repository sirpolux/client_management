package com.example.project__4.exception;

import org.springframework.http.HttpStatus;

public class CustomRuntimeException extends RuntimeException {
    private HttpStatus code;
    private String errorCode;

    public CustomRuntimeException(HttpStatus code, String message, String errorCode) {
        super(message);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        if (stackTrace.length >= 3) {
            // The calling class is at stackTrace[2]
            String callingClassName = stackTrace[2].getClassName();
            System.out.println("Calling class is: " + callingClassName);
        } else {
            System.out.println("Unable to determine calling class.");
        }
        
        this.code = code;
        this.errorCode = errorCode;
    }

    public CustomRuntimeException(HttpStatus code, String message) {
        super(message);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        // if (stackTrace.length >= 3) {
        //     // The calling class is at stackTrace[2]
        //     String callingClassName = stackTrace[2].getClassName();
        //     System.out.println("Calling class is: " + callingClassName);
        // } else {
        //     System.out.println("Unable to determine calling class.");
        // }
        this.code = code;
    }

    public HttpStatus getCode() {
        return code;
    }

    public String getErrorCode() {
        return this.errorCode;
    }
}
