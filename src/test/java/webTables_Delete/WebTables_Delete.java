package webTables_Delete;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;

public class WebTables_Delete {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void WebTables_Delete() {
        open("/webtables");
        String rowIdToDelete = "1";
        SelenideElement rowToDelete = $("#delete-record-" + rowIdToDelete);

        // 3. Сохраняем значения ячеек перед удалением
        ElementsCollection cells = rowToDelete.findAll(".cell");
        List<String> originalValues = new ArrayList<>();
        for (SelenideElement cell : cells) {
            originalValues.add(cell.getText());
        }

        // 4. Нажимаем на кнопку "Delete" в этой строке
        rowToDelete.click();

        // 5. Проверяем, что строка больше не существует (если она удаляется из DOM)
        rowToDelete.shouldNot(Condition.exist);

    }
}
