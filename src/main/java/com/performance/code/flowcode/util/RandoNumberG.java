package com.performance.code.flowcode.util;

import java.util.Random;

public class RandoNumberG {

    private RandoNumberG() {
    }

    public static Long generateNumber() {
        Random rand = new Random();
        return rand.nextLong();
    }

}