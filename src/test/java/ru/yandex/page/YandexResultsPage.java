package ru.yandex.page;


import io.qameta.allure.Step;

import ru.yandex.page.elements.Logo;
import ru.yandex.page.elements.PopupCloseButton;



public class YandexResultsPage{

    private final Logo logo = new Logo();
    private final PopupCloseButton popupCloseButton = new PopupCloseButton();

    @Step ("Закрыть всплывающее окно")
    public void closePopup(){
        popupCloseButton.closeIfVisible();
    }

    @Step("Проверка видимости логотипа")
    public void verifyLogoIsVisible() {
        logo.waitForVisible();
    }

    @Step("Проверка цвета логотипа")
    public void verifyLogoColor(String color) {
        logo.verifyColor(color);
    }
}
