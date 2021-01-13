package com.performance.code.flowcode.Entity;

import com.performance.code.flowcode.Entity.Dtos.CategoryDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;


    public CategoryDto toCategoryDto() {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(this.getId());
        categoryDto.setName(this.name);
        return categoryDto;
    }

    public void updateCategoryDto(CategoryDto categoryDto) {
        this.id = categoryDto.getId();
        this.name = categoryDto.getName();
    }
}
