package com.performance.code.flowcode.controllers.Declarative;

import com.performance.code.flowcode.Entity.Product;

import java.util.List;

public class DeclarativeProductImpl {

    public void findByPrice(List<Product> products) {
        products.sort((Product p1, Product p2) -> (int) (p1.getPrice() - p2.getPrice()));
    }

}
