package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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
}