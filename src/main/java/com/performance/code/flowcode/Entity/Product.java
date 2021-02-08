package com.performance.code.flowcode.Entity;

import com.performance.code.flowcode.Entity.Dtos.ProductDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamDoubleValue;
import uk.co.jemos.podam.common.PodamLongValue;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String name;
    @PodamDoubleValue(minValue = 1.0, maxValue = 1000.0)
    private Double price;
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
//    @PodamExclude
    private Category category;

    private int pricemock;

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


    @Override
    public String toString() {
        return "ProductID: " + id +
                " \nDescription: " + description +
                "\nName:  " + name +
                "\nPrice: " + price +
                category + "\n";
    }
}
