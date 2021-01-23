package com.performance.code.flowcode.util.service;

import com.performance.code.flowcode.Entity.Category;
import com.performance.code.flowcode.Entity.Product;
import com.performance.code.flowcode.Entity.Users;
import com.performance.code.flowcode.Repository.CategoryRepository;
import com.performance.code.flowcode.Repository.ProductRepository;
import com.performance.code.flowcode.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtractDataDb {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Category> gettAllCategory() {
        return categoryRepository.findAll();
    }

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public List<Product> getAllProducts() {return productRepository.findAll(); }
}
