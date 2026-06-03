package com.demoqa.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

import static com.demoqa.utils.RandomUtils.*;


public class FillFormTest extends TestBase {

    String firstNameFaker;
    String lastNameFaker;
    String emailFaker;
    String phoneNumberRandom;
    String currAddressFaker;
    String firstSubjectRandom;
    String secondSubjectRandom;
    String dayRandom;
    String monthRandom;
    String yearRandom;
    String sexRandom;
    String firstHobbyRandom;
    String secondHobbyRandom;
    String thirdHobbyRandom;
    String profilePicRandom;
    String stateRandom;
    String cityRandom;

    @BeforeEach
    void randomVariableGeneration () {
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
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    @Tag("Smoke")
    @Tag("Regression")
    @DisplayName("Заполнение всех параметров сложной формы")
    void fillAllParamFormTest() {
        formTestPages
                .openPage()

        //Fill String value
                .typeFirstName(firstNameFaker)
                .typeLastName(lastNameFaker)
                .typeEmail(emailFaker)
                .typeNumber(phoneNumberRandom)
                .typeCurrentAddress(currAddressFaker)
                .enterSubject(firstSubjectRandom)
                .enterSubject(secondSubjectRandom)

        //Select Date of Birth
                .clickCalendar(dayRandom, monthRandom, yearRandom)

        //Wrapper Button click
                .clickSex(sexRandom)
                .clickHobbies(firstHobbyRandom)
                .clickHobbies(secondHobbyRandom)
                .clickHobbies(thirdHobbyRandom)

        //State and City click
                .clickAndStateInput(stateRandom, cityRandom)

        //Upload image
                .uploadPicture(profilePicRandom)

        //Submit
                .submitForm()

        //Output Check
                .modalDialogApper()
                .outputBodyValueCheck("Student Name", firstNameFaker + " " + lastNameFaker)
                .outputBodyValueCheck("Student Email" , emailFaker)
                .outputBodyValueCheck("Gender" , sexRandom)
                .outputBodyValueCheck("Mobile" , phoneNumberRandom)
                .outputBodyValueCheck("Date of Birth" , dayRandom + " " + monthRandom + "," + yearRandom)
                .outputBodyValueCheck("Subjects" , firstSubjectRandom + ", " + secondSubjectRandom)
                .outputBodyHobbyCheck(firstHobbyRandom , secondHobbyRandom,thirdHobbyRandom)
                .outputBodyValueCheck("Picture" , profilePicRandom)
                .outputBodyValueCheck("Address" , currAddressFaker)
                .outputBodyValueCheck("State and City" , stateRandom + " " + cityRandom);
    }

    @Test
    @Tag("Smoke")
    @Tag("Regression")
    @DisplayName("Заполнение обязательных параметров сложной формы")
    void requiredParamFillFormTest() {
        formTestPages
                .openPage()

                //Fill String value
                .typeFirstName(firstNameFaker)
                .typeLastName(lastNameFaker)
                .typeNumber(phoneNumberRandom)

        //Select Date of Birth
                .clickCalendar(dayRandom, monthRandom, yearRandom)

        //Wrapper Button click
                .clickSex(sexRandom)

        //Submit
                .submitForm()

        //Output Check
                .modalDialogApper()
                .outputBodyValueCheck("Student Name", firstNameFaker + " " + lastNameFaker)
                .outputBodyValueCheck("Gender" , sexRandom)
                .outputBodyValueCheck("Mobile" , phoneNumberRandom)
                .outputBodyValueCheck("Date of Birth" , dayRandom + " " + monthRandom + "," + yearRandom);
    }

}