package textBox.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;

public class RegistrationPage {
    private SelenideElement
            userNameInput = $("#userName"),
            userMailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitClick = $("#submit");

    public RegistrationPage openPage() {
        open("/text-box");

        return this;
    }

    public RegistrationPage setUserName(String value) {
        userNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserMail(String value) {
        userMailInput.setValue(value);

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage SubmitClick() {
        submitClick.click();

        return this;
    }


}
