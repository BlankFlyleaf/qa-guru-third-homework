package com.demoqa.utils;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.String.format;

public class RandomUtils {

    public static void main(String[] args) {
//      System.out.println(getRandomString(8));
//      System.out.println(getRandomEmail());
//      System.out.println(getRandomInt(0, 9999));
//      System.out.println(getRandomInt(111111111, 888888888));
//      System.out.println(getRandomPhone());
//      System.out.println(getRandomGender());
//        System.out.println(getRandomInt(1, 30));
//        System.out.println(getRandomInt(1980, 2025));
    }

    public static String getRandomString(int length) {
        String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        SecureRandom rnd = new SecureRandom(); //экземпляр рандома

        for (int i = 0; i < length; i++) {
            result.append(LETTERS.charAt(rnd.nextInt(LETTERS.length())));//Добавляем в строку рандомный символ
        }

        return result.toString();
    }

    public static int getRandomInt(int min, int max) {

        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomIntToString(int min, int max) {
        int num = ThreadLocalRandom.current().nextInt(min, max + 1);

        return num < 10 ? "0" + num : String.valueOf(num);
    }

    public static String getRandomPhone() {
        String phoneTemplate = "%s%s%s%s%s";

        return format(phoneTemplate, getRandomInt(1, 9), getRandomInt(111, 999), getRandomInt(111, 999)
                , getRandomInt(11, 99), getRandomInt(1, 9));
    }

    public static String getRandomItemFromStringArray(String[] stringArray) {
        int arrayLength = stringArray.length;
        int randomIndex = getRandomInt(0, arrayLength - 1);

        return stringArray[randomIndex];
    }

    public static String getRandomSex() {
        String[] genders = {"Male",
                "Female",
                "Other"
        };

        return getRandomItemFromStringArray(genders);
    }

    public static String getRandomSubject() {
        String[] subject = {"English",
                "Math",
                "Physics",
                "Chemistry",
                "Computer Science",
                "Arts",
                "Economics"
        };

        return getRandomItemFromStringArray(subject);
    }

    public static String getRandomSubjectExcluding(String... exclude) {
        String[] subjects = {"English", "Math", "Physics", "Chemistry",
                "Computer Science", "Arts", "Economics"};

        String result;
        do {
            result = subjects[ThreadLocalRandom.current().nextInt(subjects.length)];
        } while (Arrays.asList(exclude).contains(result));

        return result;
    }

    public static String getRandomMonth() {
        String[] months = {"January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"
        };

        return getRandomItemFromStringArray(months);
    }

    public static String getRandomProfilePic() {
        String[] profilePic = {"profilePic1.jpg",
                "profilePic2.png"
        };

        return getRandomItemFromStringArray(profilePic);
    }

    public static String getRandomState() {
        String[] state = {"NCR",
                "Uttar Pradesh",
                "Haryana",
                "Rajasthan"
        };

        return getRandomItemFromStringArray(state);
    }

    public static String getRandomCityByState(String state) {
        String[] cities;

        switch (state.toLowerCase()) {
            case "ncr" -> cities = new String[]{"Delhi", "Gurgaon", "Noida"};
            case "uttar pradesh" -> cities = new String[]{"Agra", "Lucknow", "Merrut"};
            case "haryana" -> cities = new String[]{"Karnal", "Panipat"};
            case "rajasthan" -> cities = new String[]{"Jaipur", "Jaiselmer"};
            default -> throw new IllegalArgumentException("Unknown state: " + state);
        }

        return getRandomItemFromStringArray(cities);
    }


    public static String generateRandomFirstHobby() {
        String firstHobby;
        firstHobby = ThreadLocalRandom.current().nextBoolean() ? "Sports" : null;

        return firstHobby;
    }

    public static String generateRandomSecondHobby() {
    String secondHobby;
    secondHobby = ThreadLocalRandom.current().nextBoolean() ? "Reading" : null;

        return secondHobby;
    }

    public static String generateRandomThirdHobby() {
    String thirdHobby;
    thirdHobby = ThreadLocalRandom.current().nextBoolean() ? "Music" : null;

        return thirdHobby;
    }



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