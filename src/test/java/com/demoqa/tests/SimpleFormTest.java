package com.demoqa.tests;

import com.codeborne.selenide.Selenide;
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
    void randomVariableGeneration () {
        firstNameFaker = fakerRu.name().firstName();
        lastNameFaker = fakerRu.name().lastName();
        emailFaker = fakerEn.internet().emailAddress();
        corruptedEmailRandom = getRandomIntToString(1111, 9999);
        currAddressFaker = fakerRu.address().fullAddress();
        permAddressFaker = fakerRu.address().fullAddress();
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    @Tag("Smoke")
    @Tag("Regression")
    @DisplayName("Заполнение всех параметров простой формы")
    void fillAllParamSimpleFormTest() {
        simpleFormTestPages
                .openPage()

                //Fill String value
                .typeUserName(firstNameFaker + " " + lastNameFaker)
                .typeUserEmail(emailFaker)
                .typeUserCurrentAddress(currAddressFaker)
                .typeUserPermanentAddress(permAddressFaker)

                //Submit
                .submitForm()

                //Output Check
                .outputCheckValue(firstNameFaker + " " + lastNameFaker)
                .outputCheckValue(emailFaker)
                .outputCheckValue(currAddressFaker)
                .outputCheckValue(permAddressFaker);
    }

    @Test
    @Tag("Negative")
    @Tag("Smoke")
    @Tag("Regression")
    @DisplayName("Проверка валидации параметра 'email' простой формы")
    void withWrongEmailSimpleTest() {
        simpleFormTestPages
                .openPage()

                //Fill String value
                .typeUserName(firstNameFaker + " " + lastNameFaker)
                .typeUserEmail(corruptedEmailRandom)
                .typeUserCurrentAddress(currAddressFaker)
                .typeUserPermanentAddress(permAddressFaker)

                //Submit
                .submitForm()

                //Output Check
                .outputCheckEmailError("class", "mr-sm-2 field-error form-control");
    }
}
