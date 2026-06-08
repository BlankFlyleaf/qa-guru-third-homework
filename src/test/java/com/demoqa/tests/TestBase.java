package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.helpers.Attach;
import com.demoqa.pages.RegistrationFormPage;
import com.demoqa.pages.SimpleFormPage;
import com.demoqa.testdata.TestData;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    SimpleFormPage simpleFormPage = new SimpleFormPage();
    TestData testData = new TestData();

    @BeforeAll
    static void testConfig() {
        String browser = System.getProperty("BROWSER", "chrome");
        String browserVersion = System.getProperty("BROWSER_VERSION");
        String pageLoadStrategy = System.getProperty("PAGE_LOAD_STRATEGY", "eager");
        String browserSize = System.getProperty("BROWSER_SIZE", "1920x1080");
        String selenoidCredential = System.getProperty("SELENOID_CREDENTIAL");
        String selenoidUrl = System.getProperty("SELENOID_URL");
        String baseUrl = System.getProperty("BASE_URL");

        step("Задаем настройки для автотестов", () ->{
        Configuration.browser = browser;
        Configuration.browserVersion = browserVersion;
        Configuration.browserSize = browserSize;
        Configuration.pageLoadStrategy = pageLoadStrategy;
        Configuration.baseUrl = baseUrl;
        Configuration.remote = ("https://" + selenoidCredential + "@" + selenoidUrl);

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));

            if ("firefox".equals(browser)) {
                capabilities.setCapability("webSocketUrl", false);
            }
            Configuration.browserCapabilities = capabilities;
        });
    }

    @BeforeAll
    static void setUpAllure() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void generateRandomVariableForTests() {
        step("Генерируем случайные значения для заполнения параметров", () -> testData
                .randomVariableGeneration());
    }

    @AfterEach
    void tearDown() {
        step("Добавляем аттачи", () ->{
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        });
        step("Завершаем тест", Selenide::closeWebDriver);
    }
}
