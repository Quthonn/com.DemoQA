package automationPracticeForm;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(org.openqa.selenium.PageLoadStrategy.EAGER); // Try EAGER first
        Configuration.browserCapabilities = options;
    }

    @Test
    public void TextBox() {
        open("/text-box");
        $("#userName").setValue("Guru");
    }

    @Test
    public void AutomationPracticeForm() {
        open("/automation-practice-form");

//        Попробовать подобрать более читаемые на глаз селекторы

        $("#firstName").shouldBe(visible).setValue("John");
        $("#lastName").shouldBe(visible).setValue("Doe");
        $("#userEmail").shouldBe(visible).setValue("John@gmail.com");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").shouldBe(visible).setValue("1177723077");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").setValue("English").pressEnter();
        $("label[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFromClasspath("img/dog.jpeg");
        $("#currentAddress").shouldBe(visible).setValue("Wall Street 777");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Gurgaon")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the formm"));


    }
}
