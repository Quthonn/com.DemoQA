package textBox;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import textBox.Pages.RegistrationPage;

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

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void TextBox() {
        String userName = "Ivan";
        String userEmail = "mail@mail.ru";
        String currentAddress = "Wall Street 666";
        String permanentAddress = "Wall Street 6";

        registrationPage.openPage()
                .setUserName(userName)
                .setUserMail(userEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .SubmitClick()
                .nameCheck("Name:", userName)
                .mailCheck("Email:", userEmail)
                .currentAddressCheck("Current Address :", currentAddress)
                .permanentAddressCheck("Permananet Address :", permanentAddress);

    }
}
