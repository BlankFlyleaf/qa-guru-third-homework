package com.demoqa.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class NegativeFillFormTest extends TestBase {

    @Test
    @Tag("Negative")
    @Tag("Regression")
    @Story("Заполнение сложной формы demo.qa")
    @Owner("AСhurilov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка валидации параметра 'Имя' сложной формы")
    void withoutFirstNameTest() {
        registrationFormPage
                .openPage()

                .typeLastName(testData.lastNameFaker)
                .typeNumber(testData.phoneNumberRandom)
                .clickCalendar(testData.dayRandom, testData.monthRandom, testData.yearRandom)
                .clickSex(testData.sexRandom)

                .submitForm()

                .outputCheckError("#firstName","border-color", "rgb(220, 53, 69)");
    }

    @Test
    @Tag("Negative")
    @Tag("Regression")
    @Story("Заполнение сложной формы demo.qa")
    @Owner("AСhurilov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка валидации параметра 'Фамилия' сложной формы")
    void withoutSecondNameTest() {
        registrationFormPage
                .openPage()

                .typeFirstName(testData.firstNameFaker)
                .typeNumber(testData.phoneNumberRandom)
                .clickCalendar(testData.dayRandom, testData.monthRandom, testData.yearRandom)
                .clickSex(testData.sexRandom)

                .submitForm()

                .outputCheckError("#lastName","border-color", "rgb(220, 53, 69)");
    }

    @Test
    @Tag("Negative")
    @Tag("Regression")
    @Story("Заполнение сложной формы demo.qa")
    @Owner("AСhurilov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка валидации параметра 'Номер телефон' сложной формы")
    void withoutPhoneNumberTest() {
        registrationFormPage
                .openPage()

                .typeFirstName(testData.firstNameFaker)
                .typeLastName(testData.lastNameFaker)
                .clickCalendar(testData.dayRandom, testData.monthRandom, testData.yearRandom)
                .clickSex(testData.sexRandom)

                .submitForm()

                .outputCheckError("#userNumber","border-color", "rgb(220, 53, 69)");
    }
}
