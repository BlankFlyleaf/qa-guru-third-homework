package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.helpers.Attach;
import com.demoqa.pages.RegistrationFormPage;
import com.demoqa.pages.SimpleFormPage;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Locale;
import java.util.Map;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class TestBase {

    Faker fakerEn = new Faker(new Locale("en"));
    Faker fakerRu = new Faker(new Locale("ru"));
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    SimpleFormPage simpleFormPage = new SimpleFormPage();

    @BeforeAll
    static void testConfig() {
        step("Задаем настройки для тестов", () ->{
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                 "enableVNC", true,
                    "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;


        //Configuration.browser = "chrome";
        //Configuration.browserVersion = "128.0";
        //Configuration.browserVersion = "130.0";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        });
    }

    @BeforeAll
    static void setUpAllure() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void tearDown() {
        step("Добавляем аттачи", () ->{
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
//        Attach.attachAsText("Some file", "Some content");
        });
        step("Завершаем тест", Selenide::closeWebDriver);
    }
}
