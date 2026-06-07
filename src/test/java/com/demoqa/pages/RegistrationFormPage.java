package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ModalResultComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormPage {
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement numberInput = $("#userNumber");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement uploadPictureInput = $("#uploadPicture");
    private final SelenideElement sexInput = $("#genterWrapper");
    private final SelenideElement subjectInput = $("#subjectsInput");
    private final SelenideElement subjectClick = $(".subjects-auto-complete__menu");
    private final SelenideElement hobbiesInput = $("#hobbiesWrapper");
    private final SelenideElement stateCityInput = $("#stateCity-wrapper");
    private final SelenideElement formClick = $("#submit");
    private final SelenideElement calendarClick = $("#dateOfBirthInput");
    private final SelenideElement stateClick = $("#state");
    private final SelenideElement cityClick = $("#city");

    @Step("Заполняем имя - {value}")
    public RegistrationFormPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Заполняем фамилию - {value}")
    public RegistrationFormPage typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Заполняем email - {value}")
    public RegistrationFormPage typeEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    @Step("Заполняем текущий адрес - {value}")
    public RegistrationFormPage typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    @Step("Заполняем номер телефона - {value}")
    public RegistrationFormPage typeNumber(String value) {
        numberInput.setValue(value);

        return this;
    }

    @Step("Загружаем картинку профиля - {value}")
    public RegistrationFormPage uploadPicture(String value) {
        uploadPictureInput.uploadFromClasspath(value);

        return this;
    }

    @Step("Нажимаем кнопку Submit")
    public RegistrationFormPage submitForm(){
        formClick.click();

        return this;
    }

    @Step("Выбираем пол - {value}")
    public RegistrationFormPage clickSex(String value) {
        sexInput.$(byText(value)).click();

        return this;
    }

    @Step("Выбираем хобби - {value}")
    public RegistrationFormPage clickHobbies(String value) {
        if (value != null) {
            hobbiesInput.$(byText(value)).click();
        }

        return this;
    }

    @Step("Выбираем предмет - {value}")
    public RegistrationFormPage enterSubject(String value) {
        subjectInput.setValue(value);
        subjectClick.$(byText(value)).click();

        return this;
    }

    @Step("Открываем страницу сложной формы")
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    @Step("Заполняем дату рождения - {day} {month} {year}")
    public RegistrationFormPage clickCalendar(String day, String month, String year) {
        calendarClick.click();

        CalendarComponent calendar = new CalendarComponent();
        calendar.setDate(day, month, year);

        return this;
    }

    public void setState (String value) {
        stateClick.click();
        stateCityInput.$(byText(value)).click();
    }

    public void setCity (String value) {
        cityClick.click();
        stateCityInput.$(byText(value)).click();
    }

    @Step("Выбираем штат - {state} - и город - {city}")
    public RegistrationFormPage clickAndStateInput(String state, String city) {
        setState(state);
        setCity(city);
        return this;
    }

    @Step("Проверяем появлением финальной таблицы")
    public RegistrationFormPage modalDialogAppear() {
        ModalResultComponent modalResultComponent = new ModalResultComponent();
        modalResultComponent.checkTitle("Thanks for submitting the form");

        return this;
    }

    @Step("Проверяем заполнение параметра формы - {value}")
    public RegistrationFormPage outputBodyValueCheck(String name, String value) {
        ModalResultComponent modalResultComponent = new ModalResultComponent();
        modalResultComponent.checkValue(name, value);

        return this;
    }

    @Step("Проверяем заполнение хобби - {firstHobby}, {secondHobby} и {thirdHobby}")
    public RegistrationFormPage outputBodyHobbyCheck(String firstHobby, String secondHobby, String thirdHobby) {
        String expectedValue;
        ModalResultComponent modalResultComponent = new ModalResultComponent();

        if (firstHobby != null && secondHobby != null && thirdHobby != null) {
            expectedValue = firstHobby + ", " + secondHobby + ", " + thirdHobby;
        }
        else if (firstHobby != null && secondHobby != null) {
            expectedValue = firstHobby + ", " + secondHobby;
        }
        else if (firstHobby != null && thirdHobby != null) {
            expectedValue = firstHobby + ", " + thirdHobby;
        }
        else if (secondHobby != null && thirdHobby != null) {
            expectedValue = secondHobby + ", " + thirdHobby;
        }
        else if (firstHobby != null) {
            expectedValue = firstHobby;
        }
        else if (secondHobby != null) {
            expectedValue = secondHobby;
        }
        else if (thirdHobby != null) {
            expectedValue = thirdHobby;
        }
        else {
            modalResultComponent.checkEmptyHobby();

            return this;
        }

        modalResultComponent.checkValue("Hobbies", expectedValue);

        return this;
    }

    @Step("Проверяем валидацию парараметра - {nameAttr}")
    public RegistrationFormPage outputCheckError(String nameAttr, String nameElement, String value) {
        ModalResultComponent modalResultComponent = new ModalResultComponent();
        modalResultComponent.checkError(nameAttr, nameElement, value);

        return this;
    }

}
