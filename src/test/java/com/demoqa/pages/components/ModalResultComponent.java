package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class ModalResultComponent {

    private final SelenideElement modalDialog = $(".modal-dialog");
    private final SelenideElement modalTitle = $(".modal-title");
    private final SelenideElement modalTableCells = $(".table-responsive");
    private SelenideElement attributeName(String nameAttr) {
        return $(nameAttr);
    }

    public void checkTitle(String value) {
        modalDialog.should(appear);
        modalTitle.shouldHave(text(value));
    }
    public void checkValue(String name, String value) {
        modalDialog.should(appear);
        modalTableCells
                .$$( "tr")
                .findBy(text(name))
                .shouldHave(text(value));
    }
    public void checkEmptyHobby() {
        modalDialog.should(appear);
        modalTableCells
                .$$( "tr")
                .findBy(text("Hobbies"))
                .shouldHave(text("Hobbies"));
    }
    public void checkError (String nameAttr, String nameElement, String value){
        modalDialog.shouldNot(appear);
        attributeName(nameAttr).shouldHave(cssValue(nameElement, value));
    }
}
