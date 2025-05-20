package demoqa.practiceform.page.elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class TextArea extends BaseElement {
    public TextArea(SelenideElement element) {
        super(element);
    }

    @Step("Ввести текст: {text}")
    public void setText(String text) {
        element.scrollIntoView(true)
                .clear();
        element.sendKeys(text);
    }

    @Step("Добавить текст: {text} (без очистки)")
    public void appendText(String text) {
        element.scrollIntoView(true)
                .sendKeys(text);
    }

    @Step("Очистить поле ввода")
    public void clear() {
        element.scrollIntoView(true)
                .clear();
    }

    @Step("Получить текст из поля")
    public String getText() {
        return element.getText();
    }

    @Step("Проверить, что поле содержит текст: {expectedText}")
    public boolean containsText(String expectedText) {
        return getText().contains(expectedText);
    }
}
