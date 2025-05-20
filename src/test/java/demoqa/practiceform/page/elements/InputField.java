package demoqa.practiceform.page.elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class InputField extends BaseElement {
    public InputField(SelenideElement element) {
        super(element);
    }

    @Step("Ввести текст '{text}'")
    public void setText(String text) {
        element.scrollIntoView(true)
                .setValue(text);
    }
}