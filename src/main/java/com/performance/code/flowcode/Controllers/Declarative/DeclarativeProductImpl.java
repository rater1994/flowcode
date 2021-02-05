package com.performance.code.flowcode.Controllers.Declarative;

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

    public void findDuplicate(List<Product> products, String description, String name, Double price) {
        products.stream()
                .filter(o1 -> o1.getDescription().equalsIgnoreCase(description))
                .filter(o2 -> o2.getName().equalsIgnoreCase(name))
                .filter(o3 -> o3.getPrice().equals(price))
                .forEach(s1 -> System.out.println(s1.getDescription() + " " + s1.getName()  + " " + s1.getPrice()));
    }
}
