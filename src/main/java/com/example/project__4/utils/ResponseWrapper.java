package com.example.project__4.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ResponseWrapper<T> {
    private boolean status;
    private String message;
    private T data;
    private Integer code = null;
    private ResponseWrapper(){}
    public ResponseWrapper(boolean status, String message){
        this.status = status;
        this.message = message;
    }
    public ResponseWrapper(boolean status, String message, T data){
        this.status = status;
        this.message = message;
        this.data = data;
    }
    public ResponseWrapper(boolean status, String message, T data, Integer code){
        this.status = status;
        this.message= message;
        this.data = data;
        this.code = code;
    }

    public ResponseWrapper(boolean status, String message, Integer code){
        this.status = status;
        this.message = message;
        this.code = code;
    }

}
