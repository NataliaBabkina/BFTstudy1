package ru.yandex.page;

import ru.yandex.page.elements.SearchButton;
import ru.yandex.page.elements.SearchInput;
import io.qameta.allure.Step;

public class YandexMainPage {
    private final SearchInput searchInput = new SearchInput();
    private final SearchButton searchButton = new SearchButton();

    @Step("Ввод текста в поисковую строку")
    public void setSearchQuery(String query) {
        searchInput.setValue(query);
    }
    @Step("Нажатие кнопки 'Найти'")
    public YandexResultsPage goToResultsPage() {
        searchButton.click();
        return new YandexResultsPage();
    }
}
