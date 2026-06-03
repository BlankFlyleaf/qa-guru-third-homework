package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ModalResultComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormTestPages {
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement numberInput = $("#userNumber");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement uploadPictureInput = $("#uploadPicture");
    private final SelenideElement sexInput = $("#genterWrapper");
    private final SelenideElement subjectInput = $("#subjectsInput");
    private final SelenideElement hobbiesInput = $("#hobbiesWrapper");
    private final SelenideElement stateCityInput = $("#stateCity-wrapper");
    private final SelenideElement formClick = $("#submit");
    private final SelenideElement calendarClick = $("#dateOfBirthInput");
    private final SelenideElement stateClick = $("#state");
    private final SelenideElement cityClick = $("#city");

    public FormTestPages typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public FormTestPages typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public FormTestPages typeEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public FormTestPages typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public FormTestPages typeNumber(String value) {
        numberInput.setValue(value);

        return this;
    }

    public FormTestPages uploadPicture(String value) {
        uploadPictureInput.uploadFromClasspath(value);

        return this;
    }

    public FormTestPages submitForm(){
        formClick.click();

        return this;
    }

    public FormTestPages clickSex(String value) {
        sexInput.$(byText(value)).click();

        return this;
    }

    public FormTestPages clickHobbies(String value) {
        if (value != null) {
            hobbiesInput.$(byText(value)).click();
        }

        return this;
    }

    public FormTestPages enterSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public FormTestPages openPage() {
        open("/automation-practice-form");

        return this;
    }

    public FormTestPages clickCalendar(String day, String month, String year) {
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

    public FormTestPages clickAndStateInput(String state, String city) {
        setState(state);
        setCity(city);
        return this;
    }

    public FormTestPages modalDialogAppear() {
        ModalResultComponent modalResultComponent = new ModalResultComponent();
        modalResultComponent.checkTitle("Thanks for submitting the form");

        return this;
    }

    public FormTestPages outputBodyValueCheck(String name, String value) {
        ModalResultComponent modalResultComponent = new ModalResultComponent();
        modalResultComponent.checkValue(name, value);

        return this;
    }

    public FormTestPages outputBodyHobbyCheck(String firstHobby, String secondHobby, String thirdHobby) {
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

    public FormTestPages outputCheckError(String nameAttr, String nameElement, String value) {
        ModalResultComponent modalResultComponent = new ModalResultComponent();
        modalResultComponent.checkError(nameAttr, nameElement, value);

        return this;
    }

}
