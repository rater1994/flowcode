package com.performance.code.flowcode.controllers.Imperative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImperativeCategoryImpl {

    public void changeFirstLetterFromStringImp() {
        String name = "abcde";
        String[] test = new String[name.length()];

        for (int i = 0; i < name.length(); i++) {
            test[i] = String.valueOf(name.charAt(i));
            test[0] = String.valueOf(name.charAt(0)).toUpperCase();
        }

        for (String teser : test) {
            System.out.print(teser);
        }

    }

    public List<String> changeFirstLetterFromListImpBefore(List<String> list) {
        String[] test = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            test[i] = list.get(i);
            test[i] = String.valueOf(test[i].charAt(0)).toUpperCase() + String.valueOf(test[i].substring(1));
        }
        return Arrays.asList(test);
    }


    public List<String> changeFirstLetterFromListImp(List<String> list) {
        List results = new ArrayList<>();
        for (String string : list) {
            results.add(firstLeterToUpperCase(string));
        }
        return results;
    }

    public String firstLeterToUpperCase(String string) {
        return String.valueOf(string.charAt(0)).toUpperCase() + String.valueOf(string.substring(1));
    }


    private static char getFirstChar(String value) {
        return value.charAt(0);
    }

    public static void main(String[] args) {
//        changeAll();
//        changeList();
//        System.out.println(getFirstChar("ad"));
    }

}
