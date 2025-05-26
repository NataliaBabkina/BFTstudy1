package demoqa.practiceform.page.elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class Button extends BaseElement {
    public Button(SelenideElement element) {
        super(element);
    }

    @Step("Нажать на кнопку")
    public void click() {
        element.click();
    }

}
