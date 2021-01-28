package com.performance.code.flowcode.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringsUtilsTool {

    public static final String REGEX = "\\d";

    public boolean regexFind(List<String> text) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher m = pattern.matcher(text.toString());
        return m.find();
    }
}
