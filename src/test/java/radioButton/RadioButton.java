package radioButton;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.chrome.ChromeOptions;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RadioButton {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(org.openqa.selenium.PageLoadStrategy.EAGER); // Try EAGER first
        Configuration.browserCapabilities = options;
    }

    @ParameterizedTest
    @ValueSource(strings = {"yes", "no", "impressive"})
    public void radioButton(String option) {
        open("/radio-button");
        $("label[for='" + option + "Radio']").click();
        $("p").shouldHave(Condition.exactText("You have selected " + option));
    }
}
