package textBox.Pages;

import com.codeborne.selenide.SelenideElement;
import textBox.Pages.Components.ResultCheck;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    ResultCheck resultCheck = new ResultCheck();

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

    public RegistrationPage nameCheck(String key, String value) {
        resultCheck.nameCheck(key, value);

        return this;
    }

    public RegistrationPage mailCheck(String key, String value) {
        resultCheck.mailCheck(key, value);

        return this;
    }

    public RegistrationPage currentAddressCheck(String key, String value) {
        resultCheck.currentAddressCheck(key, value);

        return this;
    }

    public RegistrationPage permanentAddressCheck(String key, String value) {
        resultCheck.permanentAddressCheck(key, value);

        return this;
    }

}
