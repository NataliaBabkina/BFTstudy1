package ru.yandex.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BaseTest {
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
