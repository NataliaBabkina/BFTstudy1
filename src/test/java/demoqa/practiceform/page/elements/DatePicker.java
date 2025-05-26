package demoqa.practiceform.page.elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class DatePicker {
    private final SelenideElement element;

    public DatePicker(SelenideElement element) {
        this.element = element;
    }

    @Step("Установить дату")
    public void setDate(String date) {
        element.setValue(date).pressEnter();
    }
}
