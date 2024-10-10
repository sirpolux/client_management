package com.example.project__4.service;

import java.util.function.Consumer;

public class DataPatchingService {
    public static <T> void setFieldIfProvided(Consumer<T> fieldToBeSet, T incomingValue){
        if(incomingValue!=null){
            fieldToBeSet.accept(incomingValue);
        }
    }
}
