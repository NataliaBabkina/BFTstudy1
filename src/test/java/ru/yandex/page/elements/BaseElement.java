package ru.yandex.page.elements;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;

public abstract class BaseElement {
    protected final SelenideElement element;

    public BaseElement(SelenideElement element) {
        this.element = element;
    }

    @Step("Видимость элемента")
    public void waitForVisible(){
        element.shouldBe(visible);
    }

    @Step("Ожидание кликабельности элемента")
    public void waitForClickability(){
        element.shouldBe(visible).shouldBe(enabled);
    }

    @Step("Проверка значения атрибута элемента")
    public void verifyAttribute (String attribute, String value){
        element.shouldHave(attribute(attribute, value));
    }
}
