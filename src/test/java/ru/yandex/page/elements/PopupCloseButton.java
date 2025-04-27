package ru.yandex.page.elements;


import io.qameta.allure.Step;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;

public class PopupCloseButton extends BaseElement {

    public PopupCloseButton(){
        super($(By.xpath("/html/body/div[6]/div[2]/div/div/div/div/div[3]/button")));
    }

    @Step("Закрыть всплывающее окно")
    public void closeIfVisible (){
        if (element.exists()) {
            waitForVisible();
            element.click();
        }
    }
}
