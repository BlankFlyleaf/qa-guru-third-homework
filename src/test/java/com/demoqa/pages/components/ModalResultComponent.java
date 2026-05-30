package com.demoqa.pages.components;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class ModalResultComponent {
    public void checkTitle(String value) {
        $(".modal-dialog").should(appear);
        $(".modal-title").shouldHave(text(value));
    }
    public void checkValue(String name, String value) {
        $(".modal-dialog").should(appear);
        $(".table-responsive")
                .$$( "tr")
                .findBy(text(name))
                .shouldHave(text(value));
    }
    public void checkError (String nameAttr, String nameElement, String value){
        $(".modal-dialog").shouldNot(appear);
        $(nameAttr).shouldHave(cssValue(nameElement, value));
    }
}
