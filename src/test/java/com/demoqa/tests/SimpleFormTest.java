package com.demoqa.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static com.demoqa.utils.RandomUtils.*;

public class SimpleFormTest extends TestBase {

    String firstNameFaker;
    String lastNameFaker;
    String emailFaker;
    String corruptedEmailRandom;
    String currAddressFaker;
    String permAddressFaker;

    @BeforeEach
    @Step("Генерируем случайные данные")
    void randomVariableGeneration () {
        firstNameFaker = fakerRu.name().firstName();
        lastNameFaker = fakerRu.name().lastName();
        emailFaker = fakerEn.internet().emailAddress();
        corruptedEmailRandom = getRandomIntToString(1111, 9999);
        currAddressFaker = fakerRu.address().fullAddress();
        permAddressFaker = fakerRu.address().fullAddress();
    }

    @Test
    @Tag("Smoke")
    @Tag("Regression")
    @Story("Заполнение простой формы demo.qa")
    @Owner("AСhurilov")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Заполнение всех параметров простой формы")
    void fillAllParamSimpleFormTest() {
        simpleFormPage
                .openPage()

                .typeUserName(firstNameFaker + " " + lastNameFaker)
                .typeUserEmail(emailFaker)
                .typeUserCurrentAddress(currAddressFaker)
                .typeUserPermanentAddress(permAddressFaker)

                .submitForm()

                .outputCheckValue(firstNameFaker + " " + lastNameFaker)
                .outputCheckValue(emailFaker)
                .outputCheckValue(currAddressFaker)
                .outputCheckValue(permAddressFaker);
    }

    @Test
    @Tag("Negative")
    @Tag("Smoke")
    @Tag("Regression")
    @Story("Заполнение простой формы demo.qa")
    @Owner("AСhurilov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка валидации параметра 'email' простой формы")
    void withWrongEmailSimpleTest() {
        simpleFormPage
                .openPage()

                .typeUserName(firstNameFaker + " " + lastNameFaker)
                .typeUserEmail(corruptedEmailRandom)
                .typeUserCurrentAddress(currAddressFaker)
                .typeUserPermanentAddress(permAddressFaker)

                .submitForm()

                .outputCheckEmailError("class", "mr-sm-2 field-error form-control");
    }
}
