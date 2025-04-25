package ru.yandex.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;


public class YandexMainPage extends BasePage {
    private final SelenideElement searchInput = $("#text");
    private final SelenideElement searchButton = $("button[type='submit']");

    @Step("Ввод текста в поисковую строку")
    public void setSearchQuery(String query) {
        waitForVisibility(searchInput);
        searchInput.setValue(query);
    }
    @Step("Нажатие кнопки 'Найти'")
    public YandexResultsPage goToResultsPage() {
        waitForClickability(searchButton);
        searchButton.click();
        return new YandexResultsPage();
    }
}
