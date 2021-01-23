package com.performance.code.flowcode.util;

import java.security.SecureRandom;

public class RandoNumberG {

    public RandoNumberG() {
    }

    public static int generateNumber() {
        SecureRandom rand = new SecureRandom();
        return rand.nextInt(100);
    }

    public void generateUniqueNumber() {

    }

    public static void main(String[] args) {
        System.out.println(generateNumber());
    }

}