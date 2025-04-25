package ru.yandex.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class YandexTest extends BaseTest {

    @BeforeEach
    public void setup() {
        open("https://ya.ru/");
    }

    @Test
    public void searchTest() {

        $("#text").setValue("Тестирование");

        $("button[type='submit']").click();

        $(By.xpath("/html/body/div[6]/div[2]/div/div/div/div/div[3]/button")).click();


        $("header a.HeaderLogo").shouldBe(visible);
        $("header a.HeaderLogo svg path")
                .shouldHave(attribute("fill", "#F8604A"));

    }
}