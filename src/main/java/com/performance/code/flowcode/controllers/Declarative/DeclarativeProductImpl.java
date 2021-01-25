package com.performance.code.flowcode.controllers.Declarative;

import com.performance.code.flowcode.Entity.Product;

import java.util.List;
import java.util.stream.Collectors;

public class DeclarativeProductImpl {

    public void sortPrices(List<Product> products) {
        products.sort((Product p1, Product p2) -> (int) (p1.getPrice() - p2.getPrice()));
    }

    public List<Product> filterByPrices(List<Product> products, Double d1, Double d2) {
        return products.stream()
                .filter(product1 -> product1.getPrice() >= d1 && product1.getPrice() <= d2)
                .collect(Collectors.toList());
    }
}
