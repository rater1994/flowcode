package com.performance.code.flowcode.controllers.Imperative;

import com.performance.code.flowcode.Entity.MockData;

import java.util.ArrayList;
import java.util.List;

public class ImperativeMockDataImpl {

    public List<Integer> sortPrices(List<MockData> mockData) {
        List<Integer> getPrices = new ArrayList<>();

        for (MockData data : mockData) {
            getPrices.add((data.getPricemock()));
        }

        return getPrices.sort();
    }
}
