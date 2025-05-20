package demoqa.practiceform.page.elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.visible;

public class Checkbox {
    private final SelenideElement element;

    public Checkbox(SelenideElement element) {
        this.element = element;
    }

    @Step("Установить чекбокс")
    public void check() {
        if (!isChecked()) {
            element.click();
        }
    }

    @Step("Проверить состояние чекбокса")
    public boolean isChecked() {
        return element.is(checked);
    }

    @Step("Снять чекбокс")
    public void uncheck() {
        if (isChecked()) {
            element.click();
        }
    }

    @Step("Выбрать нессколько чекбоксов")
    public static void checkMultiple(Checkbox... checkboxes) {
        for (Checkbox checkbox : checkboxes) {
            checkbox.check();
        }
    }

    public void select() {
        element.parent().click();
    }
}
