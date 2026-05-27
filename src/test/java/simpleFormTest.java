package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.*;

public class simpleFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
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
