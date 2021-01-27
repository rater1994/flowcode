package com.performance.code.flowcode.controllers.Imperative;

import java.util.ArrayList;
import java.util.List;

public class ImperativeCategoryImpl {

    public List<String> changeFirstLetterFromListImp(List<String> list) {
        List<String> results = new ArrayList<>();
        for (String string : list) {
            results.add(firstLeterToUpperCase(string));
        }
        return results;
    }

    private String firstLeterToUpperCase(String string) {
        return String.valueOf(string.charAt(0)).toUpperCase() + String.valueOf(string.substring(1));
    }


}
