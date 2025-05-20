package demoqa.practiceform.page.elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SelectDropdown extends BaseElement {

    public SelectDropdown(SelenideElement element) {
        super(element);
    }

    @Step("Выбрать значение: {value}")
    public void select(String value) {
        element.scrollIntoView(true).click();
        $(String.format("div[id^=react-select][id$=-option-%s]", value.toLowerCase())).click();
    }
}
