package ru.yandex.page.elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class Logo extends BaseElement {

    private final SelenideElement logo = $("header a.HeaderLogo");
    //private final SelenideElement logoPath = $("header a.HeaderLogo svg path");

    public Logo(){
        super($("header a.HeaderLogo svg path"));
    }

    @Step("Проверка цвета логотипа")
    public void verifyColor (String color){
        waitForVisible();
        verifyAttribute("fill", color);
    }
}
