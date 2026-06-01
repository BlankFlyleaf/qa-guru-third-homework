package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.FormTestPages;
import com.demoqa.pages.SimpleFormTestPages;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;

import java.util.Locale;

public class TestBase {

    Faker fakerEn = new Faker(new Locale("en"));
    Faker fakerRu = new Faker(new Locale("ru"));
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
