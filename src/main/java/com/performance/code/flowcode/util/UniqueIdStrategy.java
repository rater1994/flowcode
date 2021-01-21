package com.performance.code.flowcode.util;

import uk.co.jemos.podam.common.AttributeStrategy;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Random;

public class UniqueIdStrategy implements AttributeStrategy<Random> {

    @Override
    public Random getValue(Class<?> aClass, List<Annotation> list) {
        Random random = new Random();
        random.nextInt(13);
        return random;
    }
}
