package com.performance.code.flowcode.controllers.Declarative;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Character.toUpperCase;

public class DeclarativeCategoryImpl {


    public static List<String> changeFirstLetterUpper(List<String> value) {
        return value.stream().map(strings -> strings.substring(0, 1).toUpperCase() + strings.substring(1)).collect(Collectors.toList());
    }
}
