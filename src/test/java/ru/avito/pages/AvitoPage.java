package ru.avito.pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AvitoPage {
    private final SelenideElement searchBarInput = $("input[placeholder*='Поиск по объявлениям']");
    private final SelenideElement submitButton = $("[data-marker='search-form/submit-button']");
    private final SelenideElement changeLocationButton = $("[data-marker='search-form/change-location']");
    private final SelenideElement searchLocationInput = $("[data-marker='popup-location/region/search-input']");
    private final SelenideElement saveLocationButton = $("[data-marker='popup-location/save-button']");
    private final SelenideElement categoryButton = $("[data-marker='top-rubricator/all-categories']");

    private final SelenideElement outputCheck = $("#bx_serp-item-list");
    private final SelenideElement titleCheck = $("[data-marker='page-title/text']");

    public AvitoPage typeSearch(String value) {
        searchBarInput.setValue(value);

        return this;
    }
    public AvitoPage submitSearch() {
        submitButton.pressEnter();

        return this;
    }
    public AvitoPage typeLocation(String value) {
        searchLocationInput
                .shouldBe(visible, Duration.ofSeconds(10))
                .setValue(value);

        return this;
    }
    public AvitoPage changeLocation() {
        changeLocationButton.click();

        return this;
    }
    public AvitoPage saveLocation() {
        saveLocationButton.pressEnter();

        return this;
    }
    public AvitoPage clickCategory() {
        categoryButton
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();

        return this;
    }
    public AvitoPage clickSubCategory(String value) {
        $("[data-marker='top-rubricator/sub-category-" + value +"']")
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();

        return this;
    }
    public AvitoPage openUrl() {
        open("https://www.avito.ru/");

        return this;
    }
    public AvitoPage outputCheck(String value) {
        outputCheck.shouldNotBe(empty);
        outputCheck.shouldHave(text(value));

        return this;
    }
    public AvitoPage titleCheck(String value) {
        titleCheck.shouldHave(text(value));

        return this;
    }

}
