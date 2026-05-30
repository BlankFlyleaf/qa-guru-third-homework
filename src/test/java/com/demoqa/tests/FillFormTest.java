package com.demoqa.tests;

import org.junit.jupiter.api.Test;

import static com.demoqa.testdata.TestData.*;

public class FillFormTest extends TestBase {

    @Test
    void fillFormTest() {
        formTestPages
                .openPage()

        //Fill String value
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(email)
                .typeNumber(phoneNumber)
                .typeCurrentAddress(currAddress)
                .enterSubject(fisrtSubject)
                .enterSubject(secondSubject)

        //Select Date of Birth
                .clickCalendar(day, month, year)

        //Wrapper Button click
                .clickSex(sex)
                .clickHobbies(fisrtHobby)
                .clickHobbies(secondtHobby)
                .clickHobbies(thirdHobby)

        //State and City click
                .clickAndStateInput(state, city)

        //Upload image
                .uploadPicture(profilePic)

        //Submit
                .submitForm()

        //Output Check
                .modalDialogApper(finishMessage)
                .outputBodyValueCheck("Student Name", firstName + " " + lastName)
                .outputBodyValueCheck("Student Email" , email)
                .outputBodyValueCheck("Gender" , sex)
                .outputBodyValueCheck("Mobile" , phoneNumber)
                .outputBodyValueCheck("Date of Birth" , day + " " + month + "," + year)
                .outputBodyValueCheck("Subjects" , fisrtSubject + ", " + secondSubject)
                .outputBodyValueCheck("Hobbies" , fisrtHobby + ", " + secondtHobby + ", " + thirdHobby)
                .outputBodyValueCheck("Picture" , profilePic)
                .outputBodyValueCheck("Address" , currAddress)
                .outputBodyValueCheck("State and City" , state + " " + city);
    }

    @Test
    void requiredFillFormTest() {
        formTestPages
                .openPage()

                //Fill String value
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeNumber(phoneNumber)

        //Select Date of Birth
                .clickCalendar(day, month, year)

        //Wrapper Button click
                .clickSex(sex)

        //Submit
                .submitForm()

        //Output Check
                .modalDialogApper(finishMessage)
                .outputBodyValueCheck("Student Name", firstName + " " + lastName)
                .outputBodyValueCheck("Gender" , sex)
                .outputBodyValueCheck("Mobile" , phoneNumber)
                .outputBodyValueCheck("Date of Birth" , day + " " + month + "," + year);
    }

}