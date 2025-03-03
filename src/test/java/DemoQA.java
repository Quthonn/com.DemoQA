import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class DemoQA {

    @BeforeAll
    static void beforeAll() {
//        Configuration.holdBrowserOpen = true;
//        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;

        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(org.openqa.selenium.PageLoadStrategy.EAGER); // Try EAGER first
        Configuration.browserCapabilities = options;
    }

    @Test
    public void TextBox() {
        open("https://demoqa.com/text-box");
        $("#userName").setValue("Guru");
    }

    @Test
    public void AutomationPracticeForm() {
        Configuration.holdBrowserOpen = true;
        open("https://demoqa.com/automation-practice-form");

//        Попробовать подобрать более читаемые на глаз селекторы

        $("#firstName").shouldBe(visible).setValue("John");
        $("#lastName").shouldBe(visible).setValue("Doe");
        $("#userEmail").shouldBe(visible).setValue("John@gmail.com");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").shouldBe(visible).setValue("1177723077");

        $("#subjectsInput").setValue("English").pressEnter();
        $("label[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFromClasspath("img/dog.jpeg");
        $("#currentAddress").shouldBe(visible).setValue("Wall Street 777");
//        $("html > body > div:nth-of-type(2) > div > div > div > div:nth-of-type(2) > div:nth-of-type(2) " +
//                "> form > div:nth-of-type(10) > div:nth-of-type(2) > div > div > div:nth-of-type(1) " +
//                "> div:nth-of-type(1)")
//                .click(); //State select
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Gurgaon")).click();
        $("#submit").click();
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));


        //Добавить нажатие кнопки Submit и проверку
//        $(".text-center").shouldBe(visible).shouldHave(text("Practice Form"));
    }
}
