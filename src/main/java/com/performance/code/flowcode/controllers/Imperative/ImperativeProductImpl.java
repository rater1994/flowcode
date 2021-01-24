package com.performance.code.flowcode.controllers.Imperative;

import com.performance.code.flowcode.Entity.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ImperativeProductImpl {

    public List<Double> findByPrice(List<Product> products) {
        List<Double> finalList = new ArrayList<>();
        List<Double> lastFasd = new ArrayList<>();
        Collection<Double> test = new ArrayList<>();


        for (Product p : products) {
            finalList.add(p.getPrice());
        }

        for (int i = 1; i < products.size(); i++) {
            if (finalList.get(i) > finalList.get(i + 1)) {
                finalList.add(finalList.get(i));
            } else {
                finalList.remove(i);
                finalList.add(finalList.get(i + 1));
            }
        }
        return null;
    }

    public List<Double> filterByPrices(Double price1, Double price2) {
        Product product = new Product();
        List<Double> emptyList = new ArrayList<>();

        if (price1 > price2 && price2 > price1) {
            emptyList.add(product.getPrice());
        }
        return emptyList;
    }

}
