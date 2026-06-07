package com.demoqa.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.logevents.SelenideLogger.step;
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
        step("Генерируем случайные значения для заполнения параметров", () ->{
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
        });
    }


    @Test
    @Tag("Smoke")
    @Tag("Regression")
    @Story("Заполнение сложной формы demo.qa")
    @Owner("AСhurilov")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Заполнение всех параметров сложной формы")
    void fillAllParamFormTest() {

        step("Открываем страницу регистрации", () ->{
        registrationFormPage
                .openPage();
        });

        step("Заполняем параметры формы", () ->{
        registrationFormPage
                .typeFirstName(firstNameFaker)
                .typeLastName(lastNameFaker)
                .typeEmail(emailFaker)
                .typeNumber(phoneNumberRandom)
                .typeCurrentAddress(currAddressFaker)
                .enterSubject(firstSubjectRandom)
                .enterSubject(secondSubjectRandom)
                .clickCalendar(dayRandom, monthRandom, yearRandom)
                .clickSex(sexRandom)
                .clickHobbies(firstHobbyRandom)
                .clickHobbies(secondHobbyRandom)
                .clickHobbies(thirdHobbyRandom)
                .clickAndStateInput(stateRandom, cityRandom)
                .uploadPicture(profilePicRandom);
        });

        step("Нажимаем кнопку Submit", () ->{
        registrationFormPage
                .submitForm();
        });

        step("Проверяем, что в финальном окне отображаются введенные данные", () ->{
        registrationFormPage
                .modalDialogAppear()
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
        });
    }

    @Test
    @Tag("Smoke")
    @Tag("Regression")
    @Story("Заполнение сложной формы demo.qa")
    @Owner("AСhurilov")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Заполнение обязательных параметров сложной формы")
    void requiredParamFillFormTest() {
        step("Открываем страницу регистрации", () ->{
        registrationFormPage
                .openPage();
    });

        step("Заполняем параметры формы", () ->{
        registrationFormPage
                .typeFirstName(firstNameFaker)
                .typeLastName(lastNameFaker)
                .typeNumber(phoneNumberRandom)
                .clickCalendar(dayRandom, monthRandom, yearRandom)
                .clickSex(sexRandom);
    });

        step("Нажимаем кнопку Submit", () ->{
        registrationFormPage
                .submitForm();
         });

        step("Проверяем, что в финальном окне отображаются введенные данные", () ->{
        registrationFormPage
                .modalDialogAppear()
                .outputBodyValueCheck("Student Name", firstNameFaker + " " + lastNameFaker)
                .outputBodyValueCheck("Gender" , sexRandom)
                .outputBodyValueCheck("Mobile" , phoneNumberRandom)
                .outputBodyValueCheck("Date of Birth" , dayRandom + " " + monthRandom + "," + yearRandom);
         });
    }

}