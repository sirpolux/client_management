package com.example.project__4.utils;

import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;

public class Utility {
    public Object unwrapOptional(Optional<?> entity , String entityName){
        if (entity.isPresent()){
            return entity.get();
        }
        throw new EntityNotFoundException(entityName);
    }
}
