package demoqa.practiceform.page.elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public abstract class BaseElement {
    protected SelenideElement element;

    public BaseElement(SelenideElement element) {
        this.element = element;
    }

    @Step("Проверить, что элемент отображается на странице")
    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    @Step("Проверить, что элемент активен (доступен для взаимодействия)")
    public boolean isEnabled() {
        return element.isEnabled();
    }
}