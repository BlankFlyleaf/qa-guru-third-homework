package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.FormTestPages;
import com.demoqa.pages.SimpleFormTestPages;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    FormTestPages formTestPages = new FormTestPages();
    SimpleFormTestPages simpleFormTestPages = new SimpleFormTestPages();

    @BeforeAll
    static void testConfig() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
    }
}
