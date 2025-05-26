package demoqa.practiceform.tests.frontend;

import demoqa.practiceform.page.ResultModalPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import demoqa.practiceform.page.PracticeFormPage;
import demoqa.practiceform.tests.BaseTest;



@Epic("DemoQA Tests")
@DisplayName("Заполнение формы и проверка страницы с результатом")
public class FormSubmissionTest extends BaseTest {


    private static final String FIRST_NAME = "Иван";
    private static final String LAST_NAME = "Петров";
    private static final String FULL_NAME = FIRST_NAME + " " + LAST_NAME;
    private static final String EMAIL = "test@example.com";
    private static final String MOBILE = "1234567890";
    private static final String BIRTH_DATE = "24 May 1997";
    private static final String SUBJECT = "Математика";
    private static final String HOBBIES = "Sports, Reading, Music";
    private static final String PICTURE = "test-image.jpg";
    private static final String ADDRESS = "Москва";
    private static final String STATE_AND_CITY = "NCR Delhi";

    @Test
    @DisplayName("Проверка всех полей")
    @Severity(SeverityLevel.BLOCKER)
    void allfields() {
        try {
            new PracticeFormPage()
                    .open()
                    .setFirstName(FIRST_NAME)
                    .verifyFirstName(FIRST_NAME)
                    .setLastName(LAST_NAME)
                    .verifyLastName(LAST_NAME)
                    .setEmail(EMAIL)
                    .verifyEmail(EMAIL)
                    .setMobileNumber(MOBILE)
                    .verifyMobileNumber(MOBILE)
                    .setBirthDate(BIRTH_DATE)
                    .verifyBirthDate(BIRTH_DATE)
                    .selectMaleGender()
                    .selectSportsHobby()
                    .selectReadingHobby()
                    .selectMusicHobby()
                    .setSubject(SUBJECT)
                    .verifySubject(SUBJECT)
                    .uploadPicture(PICTURE)
                    .setCurrentAddress(ADDRESS)
                    .verifyCurrentAddress(ADDRESS)
                    .setStateAndCity("NCR", "Delhi")
                    .submitForm();

            new ResultModalPage()
                    .verifyModalAppears()
                    .verifyFieldValue("Student Name", FULL_NAME)
                    .verifyFieldValue("Student Email", EMAIL)
                    .verifyFieldValue("Gender", "Male")
                    .verifyFieldValue("Mobile", MOBILE)
                    .verifyFieldValue("Date of Birth", BIRTH_DATE)
                    .verifyFieldValue("Subjects", SUBJECT)
                    .verifyFieldValue("Hobbies", HOBBIES)
                    .verifyFieldValue("Picture", PICTURE)
                    .verifyFieldValue("Address", ADDRESS)
                    .verifyFieldValue("State and City", STATE_AND_CITY)
                    .closeModal();

        } catch (Exception e) {

            Allure.addAttachment("Ошибка", "text/plain",
                    "Тест упал: " + e.getMessage() +
                            "\n\nСтек вызовов:\n" + getStackTrace(e));

            throw e;
        }
    }

    private String getStackTrace(Exception e) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement element : e.getStackTrace()) {
            sb.append(element.toString()).append("\n");
        }
        return sb.toString();
    }

    @Test
    @DisplayName("Проверка минимального количества полей полей")
    @Severity(SeverityLevel.BLOCKER)
    void minfields() {
        try {
            new PracticeFormPage()
                    .open()
                    .setFirstName(FIRST_NAME)
                    .verifyFirstName(FIRST_NAME)
                    .setLastName(LAST_NAME)
                    .verifyLastName(LAST_NAME)
                    .setMobileNumber(MOBILE)
                    .verifyMobileNumber(MOBILE)
                    .selectMaleGender()
                    .submitForm();

            new ResultModalPage()
                    .verifyModalAppears()
                    .verifyFieldValue("Student Name", FULL_NAME)
                    .verifyFieldValue("Gender", "Male")
                    .verifyFieldValue("Mobile", MOBILE)
                    .closeModal();

        } catch (Exception e) {

            Allure.addAttachment("Ошибка", "text/plain",
                    "Тест упал: " + e.getMessage() +
                            "\n\nСтек вызовов:\n" + getStackTrace(e));

            throw e;
        }
    }
}