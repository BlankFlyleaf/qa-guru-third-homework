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
        String browser = System.getProperty("BROWSER", "chrome");
        String browserVersion = System.getProperty("BROWSER_VERSION");
        String pageLoadStrategy = System.getProperty("PAGE_LOAD_STRATEGY", "eager");
        String browserSize = System.getProperty("BROWSER_SIZE", "1920x1080");
        String selenoidCredential = System.getProperty("SELENOID_CREDENTIAL");
        String selenoidUrl = System.getProperty("SELENOID_URL");
        String baseUrl = System.getProperty("BASE_URL");

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
