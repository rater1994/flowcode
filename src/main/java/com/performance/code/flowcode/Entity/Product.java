package com.performance.code.flowcode.Entity;

import com.performance.code.flowcode.Entity.Dtos.ProductDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Double price;
    private String description;

    @ManyToOne
    private Category category;

    public ProductDto toProductDto() {
        ProductDto productDto = new ProductDto();
        productDto.setId(this.getId());
        productDto.setDescription(this.description);
        productDto.setName(this.name);
        productDto.setPrice(this.price);
        productDto.setCategory(this.category);
        return productDto;
    }

    public void updateProductDto(ProductDto productDto) {
        this.id = productDto.getId();
        this.description = productDto.getDescription();
        this.name = productDto.getName();
        this.price = productDto.getPrice();
        this.category = productDto.getCategory();
    }
}
