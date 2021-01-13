package com.performance.code.flowcode.Entity.Dtos;

import com.performance.code.flowcode.Entity.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private Long id;
    private String name;
    private Double price;
    private String description;
    private Category category;
}
