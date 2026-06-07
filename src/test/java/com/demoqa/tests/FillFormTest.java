package com.demoqa.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class FillFormTest extends TestBase {

    @Test
    @Tag("Smoke")
    @Tag("Regression")
    @Story("Заполнение сложной формы demo.qa")
    @Owner("AСhurilov")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Заполнение всех параметров сложной формы")
    void fillAllParamFormTest() {
        registrationFormPage
                .openPage()

                .typeFirstName(testData.firstNameFaker)
                .typeLastName(testData.lastNameFaker)
                .typeEmail(testData.emailFaker)
                .typeNumber(testData.phoneNumberRandom)
                .typeCurrentAddress(testData.currAddressFaker)
                .enterSubject(testData.firstSubjectRandom)
                .enterSubject(testData.secondSubjectRandom)
                .clickCalendar(testData.dayRandom, testData.monthRandom, testData.yearRandom)
                .clickSex(testData.sexRandom)
                .clickHobbies(testData.firstHobbyRandom)
                .clickHobbies(testData.secondHobbyRandom)
                .clickHobbies(testData.thirdHobbyRandom)
                .clickAndStateInput(testData.stateRandom, testData.cityRandom)
                .uploadPicture(testData.profilePicRandom)

                .submitForm()

                .modalDialogAppear()
                .outputBodyValueCheck("Student Name", testData.firstNameFaker + " " + testData.lastNameFaker)
                .outputBodyValueCheck("Student Email" , testData.emailFaker)
                .outputBodyValueCheck("Gender" , testData.sexRandom)
                .outputBodyValueCheck("Mobile" , testData.phoneNumberRandom)
                .outputBodyValueCheck("Date of Birth" , testData.dayRandom + " " + testData.monthRandom + "," + testData.yearRandom)
                .outputBodyValueCheck("Subjects" , testData.firstSubjectRandom + ", " + testData.secondSubjectRandom)
                .outputBodyHobbyCheck(testData.firstHobbyRandom , testData.secondHobbyRandom, testData.thirdHobbyRandom)
                .outputBodyValueCheck("Picture" , testData.profilePicRandom)
                .outputBodyValueCheck("Address" , testData.currAddressFaker)
                .outputBodyValueCheck("State and City" , testData.stateRandom + " " + testData.cityRandom);
    }

    @Test
    @Tag("Smoke")
    @Tag("Regression")
    @Story("Заполнение сложной формы demo.qa")
    @Owner("AСhurilov")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Заполнение обязательных параметров сложной формы")
    void requiredParamFillFormTest() {
        registrationFormPage
                .openPage()

                .typeFirstName(testData.firstNameFaker)
                .typeLastName(testData.lastNameFaker)
                .typeNumber(testData.phoneNumberRandom)
                .clickCalendar(testData.dayRandom, testData.monthRandom, testData.yearRandom)
                .clickSex(testData.sexRandom)

                .submitForm()

                .modalDialogAppear()
                .outputBodyValueCheck("Student Name", testData.firstNameFaker + " " + testData.lastNameFaker)
                .outputBodyValueCheck("Gender" , testData.sexRandom)
                .outputBodyValueCheck("Mobile" , testData.phoneNumberRandom)
                .outputBodyValueCheck("Date of Birth" , testData.dayRandom + " " + testData.monthRandom + "," + testData.yearRandom);
    }
}