package com.performance.code.flowcode.util;

import com.performance.code.flowcode.Entity.Category;
import com.performance.code.flowcode.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtractDataDb {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> gettAllCategory() {
        return categoryRepository.findAll();
    }
}
