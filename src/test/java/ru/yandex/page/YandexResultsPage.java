package ru.yandex.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.attribute;

public class YandexResultsPage extends BasePage {

    private final SelenideElement logo = $("header a.HeaderLogo");
    private final SelenideElement logoPath = $("header a.HeaderLogo svg path");

    @Step ("Закрыть всплывающее окно")
    public void ClosePopup(){
        SelenideElement popupCloseButton = $(By.xpath("/html/body/div[6]/div[2]/div/div/div/div/div[3]/button"));
        if (popupCloseButton.exists()) {
            waitForVisibility(popupCloseButton);
            popupCloseButton.click();
        }
    }

    @Step("Проверка видимости логотипа")
    public void verifyLogoIsVisible() {
        waitForVisibility(logo);
    }

    @Step("Проверка цвета логотипа")
    public void verifyLogoColor(String color) {
        waitForAttribute(logoPath, "fill", color);
    }
}
