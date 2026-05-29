package com.demoqa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.*;
import static testdata.TestData.*;


public class NegativeFillFormTest extends TestBase {

    @BeforeEach
    public void targetUrl() {
        open("/automation-practice-form");
    }

    @Test
    void withOutFirstNameTest() {
        //Fill String value
        $("#lastName").setValue(lastName);
        $("#userNumber").setValue(phoneNumber);

        //Select Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--021").click();

        //Wrapper Button click
        $("#genterWrapper").$(byText(sex)).click();

        //Submit
        $("#submit").click();

        //Output Check
        $("#firstName").shouldHave(cssValue("background-image", errorSignUrl));
    }

    @Test
    void withOutSecondNameTest() {
        //Fill String value
        $("#firstName").setValue(firstName);
        $("#userNumber").setValue(phoneNumber);

        //Select Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--021").click();

        //Wrapper Button click
        $("#genterWrapper").$(byText(sex)).click();

        //Submit
        $("#submit").click();

        //Output Check
        $("#lastName").shouldHave(cssValue("background-image", errorSignUrl));
    }

    @Test
    void withOutPhoneNumberTest() {
        //Fill String value
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);

        //Select Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--021").click();

        //Wrapper Button click
        $("#genterWrapper").$(byText(sex)).click();

        //Submit
        $("#submit").click();

        //Output Check
        $("#userNumber").shouldHave(cssValue("background-image", errorSignUrl));
    }
}
