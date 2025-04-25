package ru.yandex.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;

public class BasePage {

    protected void waitForVisibility(SelenideElement element) {
        element.shouldBe(visible);
    }

    protected void waitForClickability(SelenideElement element){
        element.shouldBe(visible).shouldBe(enabled);
    }
    protected void waitForAttribute(SelenideElement element, String attribute, String value) {
        element.shouldHave(attribute(attribute, value));
    }
}
