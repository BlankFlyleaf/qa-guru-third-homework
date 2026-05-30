package com.demoqa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.*;
import static testdata.TestData.*;

public class SimpleFormTest extends TestBase {

    @BeforeEach
    public void targetUrl() {
        open("/text-box");
    }

    @Test
    void simpleFillFormTest() {
        //Fill String value
        $("#userName").setValue(firstName + " " + lastName);
        $("#userEmail").setValue(email);
        $("#currentAddress").setValue(currAddress);
        $("#permanentAddress").setValue(permAddress);

        //Submit
        $("#submit").click();

        //Output Check
        $("#output").shouldHave(text(firstName + " " + lastName));
        $("#output").shouldHave(text(email));
        $("#output").shouldHave(text(currAddress));
        $("#output").shouldHave(text(permAddress));
    }

    @Test
    void withWrongEmailSimpleTest() {
        //Fill String value
        $("#userName").setValue(firstName + " " + lastName);
        $("#userEmail").setValue(corruptedEmail);
        $("#currentAddress").setValue(currAddress);
        $("#permanentAddress").setValue(permAddress);

        //Submit
        $("#submit").click();

        //Output Check
        $("#userEmail").shouldHave(attribute("class", "mr-sm-2 field-error form-control"));
    }
}
