package demoqa.practiceform.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;

public class ResultModalPage {
    private final SelenideElement modal = $("#example-modal-sizes-title-lg");
    private final SelenideElement table = $(".table-responsive");

    @Step("Проверить, что модальное окно отображается")
    public ResultModalPage verifyModalAppears() {
        modal.shouldBe(visible);
        return this;
    }

    @Step("Проверить, что поле {field} содержит значение {value}")
    public ResultModalPage verifyFieldValue(String field, String value) {
        table.$$("tr").findBy(text(field))
                .$("td:last-child").shouldHave(text(value));
        return this;
    }

    @Step("Закрыть модальное окно")
    public void closeModal() {
        $("#closeLargeModal").click();
    }
}
