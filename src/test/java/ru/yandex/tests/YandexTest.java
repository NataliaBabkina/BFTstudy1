package ru.yandex.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;


import ru.yandex.page.YandexMainPage;
import ru.yandex.page.YandexResultsPage;

public class YandexTest extends BaseTest {

    private YandexMainPage yandexMainPage;

    @BeforeEach
    public void setup() {
        open("https://ya.ru/");
        yandexMainPage = new YandexMainPage();

    }

    @Test
    public void searchTest() {

        yandexMainPage.setSearchQuery("Тестирование");

        YandexResultsPage yandexResultsPage = yandexMainPage.goToResultsPage();

        yandexResultsPage.ClosePopup();
        yandexResultsPage.verifyLogoIsVisible();
        yandexResultsPage.verifyLogoColor("#F8604A");

    }
}