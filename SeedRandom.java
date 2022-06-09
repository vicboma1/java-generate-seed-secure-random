package com.vicboma1.develop.microservice.utils;

import java.security.SecureRandom;
import java.util.Random;

public class SeedRandom {

    /**
     * Size
     */
    public static final int SIZE = 9;

    /**
     * Random
     */
    private static Random random = new Random();

    /**
     * Secure Random
     */
    private static SecureRandom secureRandom = new SecureRandom();

    /**
     * Ascii 0
     */
    private static int LEFT_LIMIT = 48;

    /**
     * Ascii z
     */
    private static int RIGHT_LIMIT = 122;

    /**
     * Next
     * @return
     */
    public static String next() {
        return next(random,SIZE);
    }

    /**
     * Alfanumeric Secure random
     * @return
     */
    public static String nextSecure(){
        return next(secureRandom,SIZE);
    }

    /**
     * Alfanumeric random
     * @param size
     * @return
     */
    private static String next(Random random, int size){
        return random.ints(LEFT_LIMIT, RIGHT_LIMIT + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(size)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }


}
