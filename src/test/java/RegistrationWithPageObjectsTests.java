import Pages.RegistrationPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationWithPageObjectsTests {

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

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void AutomationPracticeForm() {
        String userName = "Alex";
        String lastName = "Doe";
        String userEmail = "John@gmail.com";
        String gender = "Female";
        String number = "1177723077";
        String subjects = "English";
        String hobbies = "Sports";
        String image = "img/dog.jpeg";
        String imageName = image.substring(image.lastIndexOf("/") + 1);
        //В переменной imageName хранится только название изображения без указания директории в отличии от переменной image
        String currentAddress = "Wall Street 777";
        String state = "NCR";
        String city = "Gurgaon";
        String day = "23";
        String month = "July";
        String year = "2001";
        String dateOfBirth = day + " " + month + "," + year;

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .selectGender(gender)
                .setNumber(number)
                .setBirthDate(day, month, year)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setImage(image)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .setSubmitClick()
                .verifyResultsModalAppear()
                .verifyResult("Student Name", userName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", number)
                .verifyResult("Date of Birth", dateOfBirth)
                .verifyResult("Subjects", subjects)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", imageName)
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", state + " " + city);


//        $(".table-responsive").shouldHave(text(userName), text(lastName), text(userEmail), text(gender),
//                text(number), text(subjects), text(hobbies), text(imageName),
//                text(currentAddress), text(state), text(city), text(day), text(month), text(year));


    }
}
