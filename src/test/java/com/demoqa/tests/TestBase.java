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
        String browser = System.getProperty("browser", "chrome");
        String browserVersion = System.getProperty("browserVersion");
        String pageLoadStrategy = System.getProperty("pageLoadStrategy", "eager");
        String browserSize = System.getProperty("browserSize", "1920x1080");
        String selenoidCredential = System.getProperty("selenoidCredential");
        String selenoidUrl = System.getProperty("selenoidUrl");
        String baseUrl = System.getProperty("baseUrl");

        step("Задаем настройки для тестов", () ->{
        Configuration.browser = browser;
        Configuration.browserVersion = browserVersion;
        Configuration.browserSize = browserSize;
        Configuration.pageLoadStrategy = pageLoadStrategy;
        Configuration.baseUrl = baseUrl;
        Configuration.remote = ("https://" + selenoidCredential + "@" + selenoidUrl);
        //Configuration.holdBrowserOpen = true;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                 "enableVNC", true,
                    "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
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
