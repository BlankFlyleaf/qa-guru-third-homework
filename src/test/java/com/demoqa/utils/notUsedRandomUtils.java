package com.demoqa.utils;

import java.security.SecureRandom;

import static com.demoqa.utils.RandomUtils.getRandomInt;
import static com.demoqa.utils.RandomUtils.getRandomString;
import static java.lang.String.format;

public class notUsedRandomUtils {

    //    public static void main(String[] args) {
//      System.out.println(getRandomString(8));
//      System.out.println(getRandomEmail());
//      System.out.println(getRandomInt(0, 9999));
//      System.out.println(getRandomInt(111111111, 888888888));
//      System.out.println(getRandomPhone());
//      System.out.println(getRandomGender());
//        System.out.println(getRandomInt(1, 30));
//        System.out.println(getRandomInt(1980, 2025));
//    }


    //
    //
    // Неиспользуемые примеры из урока
    //+3 (263) 253 - 66 - 12
    public static String getRandomPhone2() {
        String phoneTemplate = "+%s (%s) %s - %s - %s";

        return format(phoneTemplate, getRandomInt(1, 9), getRandomInt(111, 999), getRandomInt(111, 999)
                , getRandomInt(11, 99), getRandomInt(11, 99));
    }

    public static int getRandomInt2(int min, int max) {
        SecureRandom rnd = new SecureRandom();

        return rnd.nextInt(max - min + 1) + min;
    }

    public static String getRandomEmail2() {
        return getRandomString(8) + "@" + getRandomString(8) + ".com";
    }
    public static String getRandomEmail() {
        //return getRandomString(8) + "@" + getRandomString(8) + ".com";
        return format("%s@%s.com", getRandomString(8), getRandomString(8));
    }
}
