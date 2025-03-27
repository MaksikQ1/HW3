package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.*;

public class RegistrationPageWithFaker {
    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitButton = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultTableComponent resultTableComponent = new ResultTableComponent();

    public RegistrationPageWithFaker openPage() {
        open("/automation-practice-form");

        return this;
    }

    public RegistrationPageWithFaker removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPageWithFaker setFirstName() {
        firstNameInput.setValue(firstName);

        return this;
    }

    public RegistrationPageWithFaker setLastName() {
        lastNameInput.setValue(lastName);

        return this;
    }

    public RegistrationPageWithFaker setEmail() {
        userEmailInput.setValue(userEmail);

        return this;
    }

    public RegistrationPageWithFaker setGender() {
        genderWrapper.$(byText(gender)).click();

        return this;
    }

    public RegistrationPageWithFaker setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPageWithFaker setDateOfBirth() {
        calendarInput.click();
        calendarComponent.setDate(dayOfBirth, monthOfBirth, yearOfBirth);

        return this;
    }

    public RegistrationPageWithFaker setSubject() {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPageWithFaker setHobby() {
        hobbiesWrapper.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPageWithFaker uploadPicture() {
        uploadPictureInput.uploadFromClasspath(picture);
        return this;
    }

    public RegistrationPageWithFaker setCurrentAddress() {
        currentAddressInput.setValue(currentAddress);
        return this;
    }

    public RegistrationPageWithFaker setStateAndCity() {
        stateInput.click();
        $("#stateCity-wrapper").$(byText(state)).click();
        cityInput.click();
        $("#stateCity-wrapper").$(byText(city)).click();
        return this;
    }

    public void submitForm() {
        submitButton.click();
    }

    public ResultTableComponent getResultTable() {
        return resultTableComponent;
    }

    public void checkErrorField() {
        userNumberInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }
}