package com.example.project__4.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaginatedResponse<S> {
    private Integer page;
    private Integer totalRecords;
    private Integer totalPages;
    private S data;

    private PaginatedResponse (S data){
        this.data = data;
    }
    private PaginatedResponse(Integer page, Integer totalRecords, Integer totalPages, S data){
        this.page =page;
        this.totalRecords = totalRecords;
        this.totalPages = totalPages;
        this.data = data;
    }

    private PaginatedResponse(Integer page, Integer totalRecords, S data){
        this.page =page;
        this.totalRecords = totalRecords;
        this.data = data;
    }

}
