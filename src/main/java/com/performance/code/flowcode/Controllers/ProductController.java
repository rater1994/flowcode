package com.performance.code.flowcode.Controllers;

import com.performance.code.flowcode.Entity.Dtos.ProductDto;
import com.performance.code.flowcode.Entity.Product;
import com.performance.code.flowcode.Repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/addproduct")
    public ProductDto addproduct(@RequestBody ProductDto productDto) {
        Product product = new Product();
        product.updateProductDto(productDto);
        return productRepository.save(product).toProductDto();
    }

    @GetMapping("/getallproducts")
    public List<ProductDto> getAllProducts() {
        List<ProductDto> productDtos = new ArrayList<>();

        productRepository.findAll().forEach(product -> {
            productDtos.add(product.toProductDto());
        });

        return productDtos;
    }

    @GetMapping("/find/{id}")
    public ProductDto findById(@PathVariable Long id) {
        Optional<Product> getById = productRepository.findById(id);

        Product product = new Product();
        if (getById.isPresent()) {
            product = getById.get();
        }
        return product.toProductDto();
    }

    @DeleteMapping
    public void deleteProduct(@PathVariable Long id) {
        Optional<Product> getById = productRepository.findById(id);

        if (getById.isPresent()) {
            productRepository.deleteById(id);
            System.out.println("Deleted: " + getById);
        } else {
            System.out.println("404 not found!");
        }
    }
}
