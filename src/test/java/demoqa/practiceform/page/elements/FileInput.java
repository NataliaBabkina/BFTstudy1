package demoqa.practiceform.page.elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class FileInput {
    private final SelenideElement element;

    public FileInput(SelenideElement element) {
        this.element = element;
    }

    @Step("Загрузить файл: {filePath}")
    public void uploadFile(String filePath) {
        element.scrollIntoView(true).uploadFromClasspath(filePath);
    }
}
