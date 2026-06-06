package com.demoqa.tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

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

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    @Tag("Negative")
    @Tag("Regression")
    @Story("Заполнение сложной формы demo.qa")
    @Owner("AСhurilov")
    @Severity(SeverityLevel.CRITICAL)
    @Disabled("Для занятия 10")
    @DisplayName("Проверка валидации параметра 'Имя' сложной формы")
    void withoutFirstNameTest() {
        registrationFormPage
                .openPage()

                .typeLastName(lastNameFaker)
                .typeNumber(phoneNumberRandom)
                .clickCalendar(dayRandom, monthRandom, yearRandom)
                .clickSex(sexRandom)

                .submitForm()

                .outputCheckError("#firstName","border-color", "rgb(220, 53, 69)");
    }

    @Test
    @Tag("Negative")
    @Tag("Regression")
    @Story("Заполнение сложной формы demo.qa")
    @Owner("AСhurilov")
    @Severity(SeverityLevel.CRITICAL)
    @Disabled("Для занятия 10")
    @DisplayName("Проверка валидации параметра 'Фамилия' сложной формы")
    void withoutSecondNameTest() {
        registrationFormPage
                .openPage()

                .typeFirstName(firstNameFaker)
                .typeNumber(phoneNumberRandom)
                .clickCalendar(dayRandom, monthRandom, yearRandom)
                .clickSex(sexRandom)

                .submitForm()

                .outputCheckError("#lastName","border-color", "rgb(220, 53, 69)");
    }

    @Test
    @Tag("Negative")
    @Tag("Regression")
    @Story("Заполнение сложной формы demo.qa")
    @Owner("AСhurilov")
    @Severity(SeverityLevel.CRITICAL)
    @Disabled("Для занятия 10")
    @DisplayName("Проверка валидации параметра 'Номер телефон' сложной формы")
    void withoutPhoneNumberTest() {
        registrationFormPage
                .openPage()

                .typeFirstName(firstNameFaker)
                .typeLastName(lastNameFaker)
                .clickCalendar(dayRandom, monthRandom, yearRandom)
                .clickSex(sexRandom)

                .submitForm()

                .outputCheckError("#userNumber","border-color", "rgb(220, 53, 69)");
    }
}
