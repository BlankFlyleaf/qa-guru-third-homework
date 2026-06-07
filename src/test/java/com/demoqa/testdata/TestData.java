package com.demoqa.testdata;

import com.github.javafaker.Faker;

import java.util.Locale;

import static com.demoqa.utils.RandomUtils.*;

public class TestData {
    Faker fakerEn = new Faker(new Locale("en"));
    Faker fakerRu = new Faker(new Locale("ru"));

    public static String firstName = "Alexey";
    public static String lastName = "Churilov";
    public static String email = "test@gmail.com";
    public static String phoneNumber = "8900111234";
    public static String currAddress = "Moscow, Pushkin Street 23, Kolotushkin House, Apartament 32";
    public static String permAddress = "Voronezh, Lizyukova Street 23, Matroskin House, Apartament 32";
    public static String fisrtSubject = "History";
    public static String secondSubject = "Arts";
    public static String day = "21";
    public static String month = "September";
    public static String year = "1992";
    public static String sex = "Male";
    public static String fisrtHobby = "Sports";
    public static String secondtHobby = "Reading";
    public static String thirdHobby = "Music";
    public static String city = "Agra";
    public static String state = "Uttar Pradesh";
    public static String profilePic = "profilePic1.jpg";
    public static String finishMessage = "Thanks for submitting the form";
    public static String corruptedEmail = "1234";

    public String firstNameFaker;
    public String lastNameFaker;
    public String emailFaker;
    public String phoneNumberRandom;
    public String currAddressFaker;
    public String firstSubjectRandom;
    public String secondSubjectRandom;
    public String dayRandom;
    public String monthRandom;
    public String yearRandom;
    public String sexRandom;
    public String firstHobbyRandom;
    public String secondHobbyRandom;
    public String thirdHobbyRandom;
    public String profilePicRandom;
    public String stateRandom;
    public String cityRandom;
    public String permAddressFaker;
    public String corruptedEmailRandom;

    public void randomVariableGeneration() {

            firstNameFaker = fakerRu.name().firstName();
            lastNameFaker = fakerRu.name().lastName();
            emailFaker = fakerEn.internet().emailAddress();
            currAddressFaker = fakerRu.address().fullAddress();
            phoneNumberRandom = getRandomPhone();
            firstSubjectRandom = getRandomSubject();
            secondSubjectRandom = getRandomSubjectExcluding(firstSubjectRandom);
            sexRandom = getRandomSex();
            dayRandom = getRandomIntToString(1, 30);
            yearRandom = getRandomIntToString(1980, 2025);
            monthRandom = getRandomMonth();
            profilePicRandom = getRandomProfilePic();
            stateRandom = getRandomState();
            cityRandom = getRandomCityByState(stateRandom);
            firstHobbyRandom = generateRandomFirstHobby();
            secondHobbyRandom = generateRandomSecondHobby();
            thirdHobbyRandom = generateRandomThirdHobby();
            permAddressFaker = fakerRu.address().fullAddress();
            corruptedEmailRandom = getRandomIntToString(1111, 9999);
    }
}

