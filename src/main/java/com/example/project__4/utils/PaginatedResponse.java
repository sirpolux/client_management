package com.example.project__4.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaginatedResponse<S> {
    private int page;
    private int totalRecords;
    private int totalPages;
    private List<S> data;

    public PaginatedResponse (List<S> data){
        this.data = data;
    }
    public PaginatedResponse(int page, int totalRecords, int totalPages, List<S> data){
        this.page =page;
        this.totalRecords = totalRecords;
        this.totalPages = totalPages;
        this.data = data;
    }

    public PaginatedResponse(int page, int totalRecords, List<S> data){
        this.page =page;
        this.totalRecords = totalRecords;
        this.data = data;
    }

}
