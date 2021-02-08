package com.performance.code.flowcode.Controllers.Declarative;

import com.performance.code.flowcode.Entity.Category;
import com.performance.code.flowcode.Entity.Product;
import com.performance.code.flowcode.Repository.CategoryRepository;
import com.performance.code.flowcode.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DeclarativeProductImpl {

    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;

    public DeclarativeProductImpl(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public void sortPrices(List<Product> products) {
        products.sort((Product p1, Product p2) -> (int) (p1.getPrice() - p2.getPrice()));
    }

    public List<Product> filterByPricesDeclarativ(String categoryName, Double price1, Double price2) {
        List<Product> products = getAllProducts();

        return products.stream()
                .filter(category->category.getCategory().getName().contains(categoryName))
                .filter(product1 -> product1.getPrice() >= price1 && product1.getPrice() <= price2)
                .collect(Collectors.toList());
    }

    public void findDuplicate(List<Product> products, String description, String name, Double price) {
        products.stream()
                .filter(o1 -> o1.getDescription().equalsIgnoreCase(description))
                .filter(o2 -> o2.getName().equalsIgnoreCase(name))
                .filter(o3 -> o3.getPrice().equals(price))
                .forEach(s1 -> System.out.println(s1.getDescription() + " " + s1.getName() + " " + s1.getPrice()));
    }


    private List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
