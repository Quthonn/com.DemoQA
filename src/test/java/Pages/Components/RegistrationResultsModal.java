package Pages.Components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {
    public void verifyModalAppear() {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
//        $(".table-responsive").shouldHave(text(userName));
    }
}
