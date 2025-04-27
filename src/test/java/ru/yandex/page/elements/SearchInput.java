package ru.yandex.page.elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class SearchInput extends BaseElement {

    public SearchInput(){
        super($("#text"));
    }

    @Step("Ввод текста в поле поиска")
    public void setValue (String query){
        waitForVisible();
        element.setValue(query);
    }

}
