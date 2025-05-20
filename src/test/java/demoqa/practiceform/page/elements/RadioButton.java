package demoqa.practiceform.page.elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class RadioButton {
    private final SelenideElement element;

    public RadioButton(SelenideElement element) {
        this.element = element;
    }

    @Step("Выбрать вариант")
    public void select() {
        element.parent().click();
    }
}
