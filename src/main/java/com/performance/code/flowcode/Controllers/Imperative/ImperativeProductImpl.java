package com.performance.code.flowcode.Controllers.Imperative;

import com.performance.code.flowcode.Entity.Product;
import com.performance.code.flowcode.util.StringsUtilsTool;

import java.util.ArrayList;
import java.util.List;

public class ImperativeProductImpl {

    public List<Double> filterByPrices(List<Product> products, Double price1, Double price2) {
        List<Double> emptyList = new ArrayList<>();
        List<Double> filteredPrices = new ArrayList<>();
        for (Product p : products) {
            emptyList.add(p.getPrice());
        }

        for (Double anEmptyList : emptyList) {
            if (price1 <= anEmptyList && price2 >= anEmptyList) {
                filteredPrices.add(anEmptyList);
            }
        }
        return filteredPrices;
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
