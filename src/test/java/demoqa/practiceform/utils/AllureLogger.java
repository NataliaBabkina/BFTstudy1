package demoqa.practiceform.utils;

import io.qameta.allure.Allure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AllureLogger {
    private static final Logger logger = LoggerFactory.getLogger(AllureLogger.class);

    public static void logInfo(String message) {
        logger.info(message);
        Allure.addAttachment("Info", "text/plain", message);
    }

    public static void logError(String message, Throwable error) {
        logger.error(message, error);
        StringBuilder errorDetails = new StringBuilder()
                .append(message)
                .append("\nОшибка: ").append(error.getMessage())
                .append("\nСтек вызовов:\n");
        
        for (StackTraceElement element : error.getStackTrace()) {
            errorDetails.append(element.toString()).append("\n");
        }
        
        Allure.addAttachment("Error", "text/plain", errorDetails.toString());
    }

    public static void logFieldValidation(String fieldName, String expectedValue, String actualValue, boolean isValid) {
        String status = isValid ? "✓" : "✗";
        String message = String.format(
                "Проверка поля '%s':\n" +
                "Ожидаемое значение: %s\n" +
                "Фактическое значение: %s\n" +
                "Статус: %s",
                fieldName, expectedValue, actualValue, status
        );
        
        if (isValid) {
            logInfo(message);
        } else {
            logger.error(message);
            Allure.addAttachment("Ошибка валидации", "text/plain", message);
        }
    }
} 