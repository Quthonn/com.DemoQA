package automationPracticeForm.Pages;

import automationPracticeForm.Pages.Components.CalendarComponent;
import automationPracticeForm.Pages.Components.RegistrationResultsModal;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            gender = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            imageInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#stateCity-wrapper"),
            cityInput = $("#stateCity-wrapper"),
            submitClick = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.shouldBe(visible).setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.shouldBe(visible).setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.shouldBe(visible).setValue(value);

        return this;
    }

    public RegistrationPage selectGender(String value) {
        gender.shouldBe(visible).$(byText(value)).click();

        return this;
    }

    public RegistrationPage setNumber(String value) {
        numberInput.shouldBe(visible).setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        CalendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setImage(String value) {
        imageInput.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {

        $("#state").click();
        stateInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {

        $("#city").click();
        cityInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setSubmitClick() {
        submitClick.click();

        return this;
    }

    public RegistrationPage verifyResultsModalAppear() {
        registrationResultsModal.verifyModalAppear();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }

}
