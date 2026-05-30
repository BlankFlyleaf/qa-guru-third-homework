package com.demoqa.tests;

import org.junit.jupiter.api.Test;

import static com.demoqa.testdata.TestData.*;

public class NegativeFillFormTest extends TestBase {

    @Test
    void withOutFirstNameTest() {
        formTestPages
                .openPage()

        //Fill String value
                .typeLastName(lastName)
                .typeNumber(phoneNumber)

        //Select Date of Birth
                .clickCalendar(day, month, year)

        //Wrapper Button click
                .clickSex(sex)

        //Submit
                .submitForm()

        //Output Check
                .outputCheckError("#firstName","background-image", errorSignUrl);
    }

    @Test
    void withOutSecondNameTest() {
        formTestPages
                .openPage()

                //Fill String value
                .typeFirstName(firstName)
                .typeNumber(phoneNumber)

                //Select Date of Birth
                .clickCalendar(day, month, year)

                //Wrapper Button click
                .clickSex(sex)

                //Submit
                .submitForm()

        //Output Check
                .outputCheckError("#lastName","background-image", errorSignUrl);
    }

    @Test
    void withOutPhoneNumberTest() {
        formTestPages
                .openPage()

                //Fill String value
                .typeFirstName(firstName)
                .typeLastName(lastName)

                //Select Date of Birth
                .clickCalendar(day, month, year)

                //Wrapper Button click
                .clickSex(sex)

                //Submit
                .submitForm()

                //Output Check
                .outputCheckError("#userNumber","background-image", errorSignUrl);
    }
}
