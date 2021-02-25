package com.performance.code.flowcode.Controllers.Imperative;

import com.performance.code.flowcode.Entity.Category;
import com.performance.code.flowcode.Entity.Product;
import com.performance.code.flowcode.Repository.CategoryRepository;
import com.performance.code.flowcode.Repository.ProductRepository;
import com.performance.code.flowcode.util.StringsUtilsTool;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImperativeProductImpl {

    private ProductRepository productRepository;

    public ImperativeProductImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    public List<Product> findPriceByCategory(String categoryName, Double price1, Double price2) {
        List<Product> filteredPrices = new ArrayList<>();

        for (Product product : getAllProducts()) {
            boolean getNameCategory = product.getCategory().getName().contains(categoryName);
            if (getNameCategory && checkPrices(price1, price2, product)) {
                filteredPrices.add(product);
            }
        }
        return filteredPrices;
    }

    private boolean checkPrices(Double price1, Double price2, Product price) {
        return price.getPrice() >= price1 && price.getPrice() <= price2;
    }

    private List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public void findDuplicate(List<Product> products, String description, String name, Double price) {

        for (Product product : products) {
            if (product.getDescription().equalsIgnoreCase(description) &&
                    product.getName().equalsIgnoreCase(name) &&
                    product.getPrice().equals(price)) {
                System.out.println(product.getDescription() + " " + product.getName() + " " + product.getPrice());
            }
        }

    }

    public void checkInconsistentData(List<String> data) {
        List<String> emptyString = new ArrayList<>();

        StringsUtilsTool utilsTool = new StringsUtilsTool();

        boolean b = utilsTool.regexFind(data);

        if (b) {
            for (String s1 : data)
                emptyString.add(s1.replaceAll(StringsUtilsTool.REGEX, s1));
        }
        System.out.println(emptyString);
    }


}
