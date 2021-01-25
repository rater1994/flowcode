package com.performance.code.flowcode.controllers.Imperative;

import com.performance.code.flowcode.Entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ImperativeProductImpl {

    public List<Double> sortPrices(List<Product> products) {
        List<Double> finalList = new ArrayList<>();


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

    public List<Double> filterByPrices(List<Product> products, Double price1, Double price2) {
        List<Double> emptyList = new ArrayList<>();
        List<Double> filteredPrices = new ArrayList<>();
        for (Product p : products) {
            emptyList.add(p.getPrice());
        }

        for (int i = 0; i < emptyList.size(); i++) {
            if (price1 <= emptyList.get(i) && price2 >= emptyList.get(i)) {
                filteredPrices.add(emptyList.get(i));
            }
        }
        return filteredPrices;
    }

}
