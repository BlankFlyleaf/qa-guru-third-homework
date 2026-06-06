package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

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

    @Step("Открываем страницу простой формы")
    public SimpleFormPage openPage() {
        open("/text-box");

        return this;
    }

    @Step("Нажимаем кнопку Submit")
    public SimpleFormPage submitForm(){
        clickInput.click();

        return this;
    }

    @Step("Вводим имя юзера - {value}")
    public SimpleFormPage typeUserName(String value) {
        userNameInput.setValue(value);

        return this;
    }

    @Step("Вводим email - {value}")
    public SimpleFormPage typeUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    @Step("Вводим текущий адрес - {value}")
    public SimpleFormPage typeUserCurrentAddress(String value) {
        userCurrentAddressInput.setValue(value);

        return this;
    }

    @Step("Вводим постоянный адрес - {value}")
    public SimpleFormPage typeUserPermanentAddress(String value) {
        userPermanentAddressInput.setValue(value);

        return this;
    }

    @Step("Проверяем введеное значение - {value}")
    public SimpleFormPage outputCheckValue(String value) {
        outputCheck.shouldHave(text(value));

        return this;
    }

    @Step("Проверяем валидацию email")
    public SimpleFormPage outputCheckEmailError(String value, String s) {
        emailOutput.shouldHave(attribute(value, s));

        return this;
    }

}