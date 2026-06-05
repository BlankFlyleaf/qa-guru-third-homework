package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleFormPage {
    private final SelenideElement userNameInput = $("#userName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement userCurrentAddressInput = $("#currentAddress");
    private final SelenideElement userPermanentAddressInput = $("#permanentAddress");
    private final SelenideElement clickInput = $("#submit");
    private final SelenideElement outputCheck = $("#output");
    private final SelenideElement emailOutput = $("#userEmail");

    public SimpleFormPage openPage() {
        open("/text-box");

        return this;
    }

    public SimpleFormPage submitForm(){
        clickInput.click();

        return this;
    }

    public SimpleFormPage typeUserName(String value) {
        userNameInput.setValue(value);

        return this;
    }

    public SimpleFormPage typeUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public SimpleFormPage typeUserCurrentAddress(String value) {
        userCurrentAddressInput.setValue(value);

        return this;
    }

    public SimpleFormPage typeUserPermanentAddress(String value) {
        userPermanentAddressInput.setValue(value);

        return this;
    }

    public SimpleFormPage outputCheckValue(String value) {
        outputCheck.shouldHave(text(value));

        return this;
    }

    public SimpleFormPage outputCheckEmailError(String value, String s) {
        emailOutput.shouldHave(attribute(value, s));

        return this;
    }

}