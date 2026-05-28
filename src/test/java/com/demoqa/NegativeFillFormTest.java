package com.demoqa;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.*;


public class NegativeFillFormTest extends TestBase {

    @Test
    void withOutFirstNameTest() {
        open("/automation-practice-form");

        //Fill String value
        $("#lastName").setValue("Churilov");
        $("#userNumber").setValue("89001112345");

        //Select Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1992");
        $(".react-datepicker__day--021").click();

        //Wrapper Button click
        $("#genterWrapper").$(byText("Male")).click();

        //Submit
        $("#submit").click();

        //Output Check
        $("#firstName").shouldHave(cssValue("background-image", "url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 12 12' width='12' height='12' fill='none' stroke='%23dc3545'%3e%3ccircle cx='6' cy='6' r='4.5'/%3e%3cpath stroke-linejoin='round' d='M5.8 3.6h.4L6 6.5z'/%3e%3ccircle cx='6' cy='8.2' r='.6' fill='%23dc3545' stroke='none'/%3e%3c/svg%3e\")"));
    }

    @Test
    void withOutSecondNameTest() {
        open("/automation-practice-form");

        //Fill String value
        $("#firstName").setValue("Alexey");
        $("#userNumber").setValue("89001112345");

        //Select Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1992");
        $(".react-datepicker__day--021").click();

        //Wrapper Button click
        $("#genterWrapper").$(byText("Male")).click();

        //Submit
        $("#submit").click();

        //Output Check
        $("#lastName").shouldHave(cssValue("background-image", "url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 12 12' width='12' height='12' fill='none' stroke='%23dc3545'%3e%3ccircle cx='6' cy='6' r='4.5'/%3e%3cpath stroke-linejoin='round' d='M5.8 3.6h.4L6 6.5z'/%3e%3ccircle cx='6' cy='8.2' r='.6' fill='%23dc3545' stroke='none'/%3e%3c/svg%3e\")"));
    }

    @Test
    void withOutPhoneNumberTest() {
        open("/automation-practice-form");

        //Fill String value
        $("#firstName").setValue("Alexey");
        $("#lastName").setValue("Churilov");

        //Select Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1992");
        $(".react-datepicker__day--021").click();

        //Wrapper Button click
        $("#genterWrapper").$(byText("Male")).click();

        //Submit
        $("#submit").click();

        //Output Check
        $("#userNumber").shouldHave(cssValue("background-image", "url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 12 12' width='12' height='12' fill='none' stroke='%23dc3545'%3e%3ccircle cx='6' cy='6' r='4.5'/%3e%3cpath stroke-linejoin='round' d='M5.8 3.6h.4L6 6.5z'/%3e%3ccircle cx='6' cy='8.2' r='.6' fill='%23dc3545' stroke='none'/%3e%3c/svg%3e\")"));
    }
}
