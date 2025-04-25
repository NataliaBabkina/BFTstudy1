package ru.yandex.page.elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class SearchButton extends BaseElement {

    public SearchButton(){
        super($("button[type='submit']"));
    }

    @Step("Нажатие на кнопку 'Найти'")
    public void click (){
        waitForClickability();
        element.click();
    }
}
