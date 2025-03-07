package textBox;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBox {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(org.openqa.selenium.PageLoadStrategy.EAGER); // Try EAGER first
        Configuration.browserCapabilities = options;
        Configuration.browserSize = "1920x880";
    }

    @Test
    public void TextBox() {
        String userName = "Ivan";
        String userEmail = "mail@mail.ru";
        String currentAddress = "Wall Street 666";
        String permanentAddress = "Wall Street 6";

        open("/text-box");
        $("#userName").setValue(userName);
        $("#userEmail").setValue(userEmail);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);
        $("#submit").shouldHave(visible).click();

        $("div[class*='col-md-12']").$(byText("Name:")).parent().shouldHave(text(userName));
        $("div[class*='col-md-12']").$(byText("Email:")).parent().shouldHave(text(userEmail));
        $("div[class*='col-md-12']").$(byText("Current Address :")).parent().shouldHave(text(currentAddress));
        $("div[class*='col-md-12']").$(byText("Permananet Address :")).parent().shouldHave(text(permanentAddress));

    }
}
