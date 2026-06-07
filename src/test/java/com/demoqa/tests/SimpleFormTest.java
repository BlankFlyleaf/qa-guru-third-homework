package com.demoqa.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SimpleFormTest extends TestBase {

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

                .typeUserName(testData.firstNameFaker + " " + testData.lastNameFaker)
                .typeUserEmail(testData.emailFaker)
                .typeUserCurrentAddress(testData.currAddressFaker)
                .typeUserPermanentAddress(testData.permAddressFaker)

                .submitForm()

                .outputCheckValue(testData.firstNameFaker + " " + testData.lastNameFaker)
                .outputCheckValue(testData.emailFaker)
                .outputCheckValue(testData.currAddressFaker)
                .outputCheckValue(testData.permAddressFaker);
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

                .typeUserName(testData.firstNameFaker + " " + testData.lastNameFaker)
                .typeUserEmail(testData.corruptedEmailRandom)
                .typeUserCurrentAddress(testData.currAddressFaker)
                .typeUserPermanentAddress(testData.permAddressFaker)

                .submitForm()

                .outputCheckEmailError("class", "mr-sm-2 field-error form-control");
    }
}
