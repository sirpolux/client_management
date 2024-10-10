package com.example.project__4.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;





@Data
@NoArgsConstructor
public class PaginationDTO {
    private Integer page;
    @Max(message = "Max page size is 20", value = 20)
    @Min(message = "Minimum page size is 10", value = 10)
    private Integer size;
    private String sortingParameter = "createdAt";
    private  String sortingOrder= "desc";
    private String searchFilter;


    public Pageable getPaginationCriteria(String customSortingParam){
        this.page = this.page ==null?0:this.page;

        if (page>0){
            this.page--;
        }
        String sortingParam = customSortingParam==null? sortingParameter:customSortingParam;

        if (this.sortingOrder.equals("desc")){
            return PageRequest.of(this.page, this.size, Sort.by(sortingParam).descending());
        }else{
            return PageRequest.of(this.page, this.size, Sort.by(sortingParam).ascending());
        }
    }
}
