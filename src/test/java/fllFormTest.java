package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.*;

public class thirdHomework {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        //Fill String value
        $("#firstName").setValue("Alexey");
        $("#lastName").setValue("Churilov");
        $("#userEmail").setValue("test@gmail.com");
        $("#userNumber").setValue("89001112345");
        $("#currentAddress").setValue("Moscow, Pushkin Street 23, Kolotushkin House, Apartament 32");
        $("#subjectsInput").setValue("History").pressEnter();
        $("#subjectsInput").setValue("Arts").pressEnter();

        //Select Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1992");
        $(".react-datepicker__day--021").click();

        //Wrapper Button click
        $("#genterWrapper").$(byText("Male")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();

        //State and City click
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();

        //Upload image
        $("#uploadPicture").uploadFromClasspath("profilePic.jpg");

        //Submit
        $("#submit").click();

        //Output Check
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Alexey Churilov"));
        $(".modal-body").shouldHave(text("test@gmail.com"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("8900111234"));
        $(".modal-body").shouldHave(text("21 September,1992"));
        $(".modal-body").shouldHave(text("History, Arts"));
        $(".modal-body").shouldHave(text("Sports, Reading, Music"));
        $(".modal-body").shouldHave(text("profilePic.jpg"));
        $(".modal-body").shouldHave(text("Moscow, Pushkin Street 23, Kolotushkin House, Apartament 32"));
        $(".modal-body").shouldHave(text("Uttar Pradesh Agra"));
    }

    @Test
    void requiredFillFormTest() {
        open("/automation-practice-form");

        //Fill String value
        $("#firstName").setValue("Alexey");
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
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Alexey Churilov"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("8900111234"));
        $(".modal-body").shouldHave(text("21 September,1992"));
    }

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
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Alexey Churilov"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("8900111234"));
        $(".modal-body").shouldHave(text("21 September,1992"));
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
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Alexey Churilov"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("8900111234"));
        $(".modal-body").shouldHave(text("21 September,1992"));
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

    @Test
    void simpleFillFormTest() {
        open("/text-box");

        //Fill String value
        $("#userName").setValue("Alexey Churilov");
        $("#userEmail").setValue("test@gmail.com");
        $("#currentAddress").setValue("Pushkina street, Kolotushkin house");
        $("#permanentAddress").setValue("Lyoshkina street, Pushkina house");

        //Submit
        $("#submit").click();

        //Output Check
        $("#output").shouldHave(text("Alexey Churilov"));
        $("#output").shouldHave(text("test@gmail.com"));
        $("#output").shouldHave(text("Pushkina street, Kolotushkin house"));
        $("#output").shouldHave(text("Lyoshkina street, Pushkina house"));
    }

    @Test
    void withWrongtEmailSimpleTest() {
        open("/text-box");

        //Fill String value
        $("#userName").setValue("Alexey Churilov");
        $("#userEmail").setValue("1234");
        $("#currentAddress").setValue("Pushkina street, Kolotushkin house");
        $("#permanentAddress").setValue("Lyoshkina street, Pushkina house");

        //Submit
        $("#submit").click();

        //Output Check
        $("#userEmail").shouldHave(attribute("class", "mr-sm-2 field-error form-control"));
    }
}