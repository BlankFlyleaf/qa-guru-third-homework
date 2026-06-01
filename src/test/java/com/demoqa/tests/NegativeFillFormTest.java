package com.demoqa.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.demoqa.utils.RandomUtils.*;

public class NegativeFillFormTest extends TestBase {

    String firstNameFaker;
    String lastNameFaker;
    String phoneNumberRandom;
    String dayRandom;
    String monthRandom;
    String yearRandom;
    String sexRandom;

    @BeforeEach
    void randomVariableGeneration () {
        firstNameFaker = fakerRu.name().firstName();
        lastNameFaker = fakerRu.name().lastName();
        phoneNumberRandom = getRandomPhone();
        sexRandom = getRandomSex();
        dayRandom = getRandomIntToString(1, 30);
        yearRandom = getRandomIntToString(1980, 2025);
        monthRandom = getRandomMonth();
    }

    @Test
    void withOutFirstNameTest() {
        formTestPages
                .openPage()

        //Fill String value
                .typeLastName(lastNameFaker)
                .typeNumber(phoneNumberRandom)

        //Select Date of Birth
                .clickCalendar(dayRandom, monthRandom, yearRandom)

        //Wrapper Button click
                .clickSex(sexRandom)

        //Submit
                .submitForm()

        //Output Check
                .outputCheckError("#firstName","border-color", "rgb(220, 53, 69)");
    }

    @Test
    void withOutSecondNameTest() {
        formTestPages
                .openPage()

                //Fill String value
                .typeFirstName(firstNameFaker)
                .typeNumber(phoneNumberRandom)

                //Select Date of Birth
                .clickCalendar(dayRandom, monthRandom, yearRandom)

                //Wrapper Button click
                .clickSex(sexRandom)

                //Submit
                .submitForm()

        //Output Check
                .outputCheckError("#lastName","border-color", "rgb(220, 53, 69)");
    }

    @Test
    void withOutPhoneNumberTest() {
        formTestPages
                .openPage()

                //Fill String value
                .typeFirstName(firstNameFaker)
                .typeLastName(lastNameFaker)

                //Select Date of Birth
                .clickCalendar(dayRandom, monthRandom, yearRandom)

                //Wrapper Button click
                .clickSex(sexRandom)

                //Submit
                .submitForm()

                //Output Check
                .outputCheckError("#userNumber","border-color", "rgb(220, 53, 69)");
    }
}
