package ru.yandex.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class YandexTest {

    @BeforeAll
    public static void setupAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 15000;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
                .includeSelenideSteps(true));

        Configuration.reportsFolder = "target/allure-results";
    }

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

    private void takeScreenshot(String name) throws IOException {

        String screenshotPath = Selenide.screenshot(name);
        if (screenshotPath.startsWith("file:/")) {
            screenshotPath = screenshotPath.substring(6);
        }
        Allure.addAttachment(name,
                Files.newInputStream(Paths.get(screenshotPath)));
    }

    @AfterEach
    public void tearDown()throws IOException {
        takeScreenshot("final-state");
        Selenide.closeWebDriver();
    }
}