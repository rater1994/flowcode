package com.performance.code.flowcode.controllers;

import com.performance.code.flowcode.Entity.Category;
import com.performance.code.flowcode.Entity.Dtos.CategoryDto;
import com.performance.code.flowcode.Repository.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping("/addcategory")
    public CategoryDto addCategory(@RequestBody CategoryDto categoryDto) {
        Category category = new Category();
        category.updateCategoryDto(categoryDto);
        return categoryRepository.save(category).toCategoryDto();
    }

    @GetMapping("/getcategory")
    public List<CategoryDto> getAllCategory() {
        List<CategoryDto> categoryDtos = new ArrayList<>();

        categoryRepository.findAll().forEach(category -> {
            categoryDtos.add(category.toCategoryDto());
        });

        return categoryDtos;
    }

    @GetMapping("/getcategory/{id}")
    public CategoryDto findById(@RequestParam Long id) {
        Optional<Category> findById = categoryRepository.findById(id);

        Category category = new Category();
        if (findById.isPresent()){
            category = findById.get();
        }
        return category.toCategoryDto();
    }

    @PutMapping("/update/{id}")
    public CategoryDto updateCategory(@RequestBody CategoryDto categoryDto,@RequestParam Long id) {
        Category category = new Category();

        Optional<Category> findById = categoryRepository.findById(id);

        if (findById.isPresent()) {
            category = findById.get();
            category.setName(categoryDto.getName());
            categoryRepository.save(category);
        }

        return category.toCategoryDto();
    }

    @DeleteMapping
    public void deleteCategory(@PathVariable Long id) {
        Optional<Category> findById = categoryRepository.findById(id);

        if (findById.isPresent()) {
            categoryRepository.deleteById(id);
            System.out.println("Delete " + findById);
        }
    }

}
