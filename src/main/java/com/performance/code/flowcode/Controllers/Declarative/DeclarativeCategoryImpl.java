package com.performance.code.flowcode.Controllers.Declarative;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DeclarativeCategoryImpl {

    private DeclarativeCategoryImpl() {
    }

    public static List<String> changeFirstLetterUpper(List<String> value) {
        Function<String, String> firstLetterToUpperCase = strings -> strings.substring(0, 1).toUpperCase() + strings.substring(1);
        return value.stream()
                .map(firstLetterToUpperCase)
                .collect(Collectors.toList());
    }
}
