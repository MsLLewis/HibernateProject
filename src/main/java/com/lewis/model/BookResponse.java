package com.lewis.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class BookResponse {

    private String bookIsbn;
    private String authorName;
    private Double netPrice;


}
