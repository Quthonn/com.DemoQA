package textBox.Pages.Components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;

public class ResultCheck {
    public SelenideElement
        userNameInput = $("#name"),
        userMailInput = $("#email"),
        currentAddressInput = $("p[id='currentAddress']"),
        permanentAddressInput = $("p[id='permanentAddress']");

    public void nameCheck(String key, String value) {
        userNameInput.shouldHave(exactText(key + value));
    }

    public void mailCheck(String key, String value) {
        userMailInput.shouldHave(exactText(key + value));
    }

    public void currentAddressCheck(String key, String value) {
        currentAddressInput.shouldHave(exactText(key + value));
    }

    public void permanentAddressCheck(String key, String value) {
        permanentAddressInput.shouldHave(exactText(key + value));
    }
}
