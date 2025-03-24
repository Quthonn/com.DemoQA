package automationPracticeFormJavaFaker;
import automationPracticeForm.Pages.RegistrationPage;
import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Locale;

public class RegistrationWithPageObjectsTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(org.openqa.selenium.PageLoadStrategy.EAGER); // Try EAGER first
        Configuration.browserCapabilities = options;
    }

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void AutomationPracticeForm() {
        Faker faker = new Faker(new Locale("ru"));

        String userName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String gender = "Female";
        // 10 цифр в номере должно быть
        String number = faker.number().digits(10);
        String subjects = "English";
        String hobbies = "Sports";
        String image = "img/dog.jpeg";
        String imageName = image.substring(image.lastIndexOf("/") + 1);
        //В переменной imageName хранится только название изображения без указания директории в отличии от переменной image
        String currentAddress = faker.address().streetAddress();
        String state = "NCR";
        String city = "Gurgaon";
        String day = "21";
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
    }
}
