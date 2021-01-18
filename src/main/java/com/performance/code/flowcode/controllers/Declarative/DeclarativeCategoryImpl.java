package com.performance.code.flowcode.controllers.Declarative;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Character.toUpperCase;

public class DeclarativeCategoryImpl {

    public static List<String> changeFirstLetterToUpper(List<String> words) {
        return words.stream()
                .map(value -> {
                    char firstChar = value.charAt(0);
                    firstChar = toUpperCase(firstChar);
                    return firstChar + value;
                }).collect(Collectors.toList());
    }

    public static List<String> test(List<String> value) {
       return value.stream().map(strings -> strings.substring(0, 1).toUpperCase() + strings.substring(1)).collect(Collectors.toList());
    }
}
