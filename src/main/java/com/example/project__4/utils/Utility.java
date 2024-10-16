package com.example.project__4.utils;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;


@Configuration
public class Utility {

    public Object unwrapOptional(Optional<?> entity , String entityName){
        if (entity.isPresent()){
            return entity.get();
        }
        throw new EntityNotFoundException(entityName);
    }
}
