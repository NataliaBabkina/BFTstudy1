package demoqa.practiceform.tests.frontend;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import demoqa.practiceform.page.PracticeFormPage;
import demoqa.practiceform.tests.BaseTest;

@Epic("DemoQA Tests")
@DisplayName("Валидация формы")
public class FormValidationTest extends BaseTest {
    private static final String FIRST_NAME = "1111";
    private static final String LAST_NAME = "2222";
    private static final String FULL_NAME = FIRST_NAME + " " + LAST_NAME;
    private static final String EMAIL = "тооо";
    private static final String MOBILE = "12";



    @Test
    @DisplayName("Проверка валидации почты и номера телефона")
    @Severity(SeverityLevel.CRITICAL)
    void shouldValidateRequiredFields() {
        new PracticeFormPage()
                .open()
                .setEmail(EMAIL)
                .setMobileNumber(MOBILE)
                .submitForm()
                .verifyValidationColor("#userEmail")
                .verifyValidationColor("#userNumber");

    }


}
