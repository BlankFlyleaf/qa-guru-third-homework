package com.demoqa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static testdata.TestData.*;

public class FillFormTest extends TestBase {

    @BeforeEach
    public void targetUrl() {
        open("/automation-practice-form");
    }

    @Test
    void fillFormTest() {
        //Fill String value
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#userNumber").setValue(phoneNumber);
        $("#currentAddress").setValue(currAddress);
        $("#subjectsInput").setValue(fisrtSubject).pressEnter();
        $("#subjectsInput").setValue(secondSubject).pressEnter();

        //Select Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--021").click();

        //Wrapper Button click
        $("#genterWrapper").$(byText(sex)).click();
        $("#hobbiesWrapper").$(byText(fisrtHobby)).click();
        $("#hobbiesWrapper").$(byText(secondtHobby)).click();
        $("#hobbiesWrapper").$(byText(thirdHobby)).click();

        //State and City click
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        //Upload image
        $("#uploadPicture").uploadFromClasspath(profilePic);

        //Submit
        $("#submit").click();

        //Output Check
        $(".modal-title").shouldHave(text(finishMessage));
        $(".modal-body").shouldHave(text(firstName + " " + lastName));
        $(".modal-body").shouldHave(text(email));
        $(".modal-body").shouldHave(text(sex));
        $(".modal-body").shouldHave(text(phoneNumber));
        $(".modal-body").shouldHave(text(day + " " + month + "," + year));
        $(".modal-body").shouldHave(text(fisrtSubject + ", " + secondSubject));
        $(".modal-body").shouldHave(text(fisrtHobby + ", " + secondtHobby + ", " + thirdHobby));
        $(".modal-body").shouldHave(text(profilePic));
        $(".modal-body").shouldHave(text(currAddress));
        $(".modal-body").shouldHave(text(state + " " + city));
    }

    @Test
    void requiredFillFormTest() {
       //Fill String value
        $("#firstName").setValue(firstName);
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
        $(".modal-title").shouldHave(text(finishMessage));
        $(".modal-body").shouldHave(text(firstName + " " + lastName));
        $(".modal-body").shouldHave(text(sex));
        $(".modal-body").shouldHave(text(phoneNumber));
        $(".modal-body").shouldHave(text(day + " " + month + "," + year));
    }

}