package ru.avito.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import ru.avito.pages.AvitoPage;

public class TestBase {

    AvitoPage avitoPage = new AvitoPage();

    @BeforeAll
    static void testConfig() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://www.avito.ru/";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;

    }
}
