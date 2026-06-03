package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleFormTestPages {
    private final SelenideElement userNameInput = $("#userName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement userCurrentAddressInput = $("#currentAddress");
    private final SelenideElement userPermanentAddressInput = $("#permanentAddress");
    private final SelenideElement clickInput = $("#submit");
    private final SelenideElement outputCheck = $("#output");
    private final SelenideElement emailOutput = $("#userEmail");

    public SimpleFormTestPages openPage() {
        open("/text-box");

        return this;
    }

    public SimpleFormTestPages submitForm(){
        clickInput.click();

        return this;
    }

    public SimpleFormTestPages typeUserName(String value) {
        userNameInput.setValue(value);

        return this;
    }

    public SimpleFormTestPages typeUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public SimpleFormTestPages typeUserCurrentAddress(String value) {
        userCurrentAddressInput.setValue(value);

        return this;
    }

    public SimpleFormTestPages typeUserPermanentAddress(String value) {
        userPermanentAddressInput.setValue(value);

        return this;
    }

    public SimpleFormTestPages outputCheckValue(String value) {
        outputCheck.shouldHave(text(value));

        return this;
    }

    public SimpleFormTestPages outputCheckEmailError(String value, String s) {
        emailOutput.shouldHave(attribute(value, s));

        return this;
    }

}