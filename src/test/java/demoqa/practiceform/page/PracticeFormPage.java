package demoqa.practiceform.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import demoqa.practiceform.page.elements.*;
import demoqa.practiceform.utils.AllureLogger;
import io.qameta.allure.Step;
import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PracticeFormPage {
    private InputField firstName() { return new InputField($("#firstName")); }
    private InputField lastName() { return new InputField($("#lastName")); }
    private InputField email() { return new InputField($("#userEmail")); }
    private InputField mobile() { return new InputField($("#userNumber")); }
    private InputField subjects() { return new InputField($("#subjectsInput")); }

    private RadioButton maleGender() { return new RadioButton($("#gender-radio-1")); }
    private RadioButton femaleGender() { return new RadioButton($("#gender-radio-2")); }
    private RadioButton otherGender() { return new RadioButton($("#gender-radio-3")); }

    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private final SelenideElement monthSelect = $(".react-datepicker__month-select");
    private final SelenideElement yearSelect = $(".react-datepicker__year-select");

    private Checkbox sportsHobby() { return new Checkbox($("#hobbies-checkbox-1")); }
    private Checkbox readingHobby() { return new Checkbox($("#hobbies-checkbox-2")); }
    private Checkbox musicHobby() { return new Checkbox($("#hobbies-checkbox-3")); }

    private DatePicker dateOfBirth() { return new DatePicker($("#dateOfBirthInput")); }
    private FileInput pictureUpload() { return new FileInput($("#uploadPicture")); }
    private TextArea currentAddress() { return new TextArea($("#currentAddress")); }
    private SelectDropdown state() { return new SelectDropdown($("#state")); }
    private SelectDropdown city() { return new SelectDropdown($("#city")); }
    private Button submit() { return new Button($("#submit")); }
    private InputField mobileNumber() { return new InputField($("#userNumber")); }

    private SelenideElement form() { return $("#userForm"); }

    @Step("Открыть страницу формы")
    public PracticeFormPage open() {
        Selenide.open("/automation-practice-form");
        $("#userForm").shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }

    @Step("Ввести имя: {name}")
    public PracticeFormPage setFirstName(String name) {
        firstName().setText(name);
        return this;
    }

    @Step("Ввести фамилию: {lastName}")
    public PracticeFormPage setLastName(String lastName) {
        lastName().setText(lastName);
        return this;
    }

    @Step("Ввести email: {email}")
    public PracticeFormPage setEmail(String email) {
        email().setText(email);
        return this;
    }

    @Step("Ввести номер телефона: {number}")
    public PracticeFormPage setMobileNumber(String number) {
        mobileNumber().setText(number);
        return this;
    }

    @Step("Отправить форму")
    public PracticeFormPage submitForm() {
        submit().click();
        return this;
    }

    @Step("Проверить вvалидацию (поля окрашены красным)")
    public PracticeFormPage verifyValidationColor(String fieldId) {
        $(fieldId)
                .shouldBe(visible, Duration.ofSeconds(5))
                .shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

        return this;
    }


    @Step("Открыть календарь даты рождения")
    public PracticeFormPage openBirthDatePicker() {
        dateOfBirthInput.click();
        return this;
    }

    @Step("Выбрать месяц рождения: {month}")
    public PracticeFormPage selectBirthMonth(String month) {
        monthSelect.selectOption(month);
        return this;
    }

    @Step("Выбрать год рождения: {year}")
    public PracticeFormPage selectBirthYear(String year) {
        yearSelect.selectOption(year);
        return this;
    }

    @Step("Выбрать день рождения: {day}")
    public PracticeFormPage selectBirthDay(String day) {
        String dayLocator = String.format(
                "//div[contains(@class, 'react-datepicker__day') and not(contains(@class, 'outside-month')) and text()='%s']",
                day
        );
        $x(dayLocator)
                .shouldBe(visible, Duration.ofSeconds(5))
                .click();
        return this;
    }

    @Step("Установить дату рождения: {birthDate}")
    public PracticeFormPage setBirthDate(String birthDate) {

        String[] parts = birthDate.split(" ");

        String day = parts[0];
        String month = parts[1];
        String year = parts[2];

        return setBirthDate(day, month, year);
    }

    @Step("Установить дату рождения: {day} {month} {year}")
    public PracticeFormPage setBirthDate(String day, String month, String year) {
        return openBirthDatePicker()
                .selectBirthMonth(month)
                .selectBirthYear(year)
                .selectBirthDay(day);
    }

    @Step("Выбрать пол: Male")
    public PracticeFormPage selectMaleGender() {
        maleGender().select();
        return this;
    }

    @Step("Выбрать хобби: Sports")
    public PracticeFormPage selectSportsHobby() {
        sportsHobby().select();
        return this;
    }

    @Step("Выбрать хобби: Reading")
    public PracticeFormPage selectReadingHobby() {
        readingHobby().select();
        return this;
    }

    @Step("Выбрать хобби: Music")
    public PracticeFormPage selectMusicHobby() {
        musicHobby().select();
        return this;
    }

    @Step("Ввести предмет: {subject}")
    public PracticeFormPage setSubject(String subject) {
        subjects().setText(subject);
        return this;
    }

    @Step("Загрузить изображение: {filePath}")
    public PracticeFormPage uploadPicture(String filePath) {
        File file = new File("src/test/resources/" + filePath);
        if (!file.exists()) {
            throw new RuntimeException("Файл не найден: " + file.getAbsolutePath());
        }
        $("#uploadPicture").uploadFile(file);
        return this;
    }

    @Step("Ввести текущий адрес: {address}")
    public PracticeFormPage setCurrentAddress(String address) {
        currentAddress().setText(address);
        return this;
    }

    @Step("Выбрать штат: {stateName}")
    public PracticeFormPage setState(String stateName) {
        $("#state").scrollIntoView(true).click();
        $("#stateCity-wrapper").$("#react-select-3-option-0").shouldBe(visible).click();
        return this;
    }

    @Step("Выбрать город: {cityName}")
    public PracticeFormPage setCity(String cityName) {
        $("#city").scrollIntoView(true).click();
        $("#stateCity-wrapper").$("#react-select-4-option-0").shouldBe(visible).click();
        return this;
    }

    @Step("Выбрать штат и город")
    public PracticeFormPage setStateAndCity(String stateName, String cityName) {
        setState(stateName);
        setCity(cityName);
        return this;
    }

    @Step("Проверить имя: {expectedName}")
    public PracticeFormPage verifyFirstName(String expectedName) {
        String actualValue = $("#firstName").getValue();
        boolean isValid = actualValue.equals(expectedName);
        AllureLogger.logFieldValidation("Имя", expectedName, actualValue, isValid);
        $("#firstName").shouldHave(value(expectedName));
        return this;
    }

    @Step("Проверить фамилию: {expectedLastName}")
    public PracticeFormPage verifyLastName(String expectedLastName) {
        String actualValue = $("#lastName").getValue();
        boolean isValid = actualValue.equals(expectedLastName);
        AllureLogger.logFieldValidation("Фамилия", expectedLastName, actualValue, isValid);
        $("#lastName").shouldHave(value(expectedLastName));
        return this;
    }

    @Step("Проверить email: {expectedEmail}")
    public PracticeFormPage verifyEmail(String expectedEmail) {
        String actualValue = $("#userEmail").getValue();
        boolean isValid = actualValue.equals(expectedEmail);
        AllureLogger.logFieldValidation("Email", expectedEmail, actualValue, isValid);
        $("#userEmail").shouldHave(value(expectedEmail));
        return this;
    }

    @Step("Проверить номер телефона: {expectedNumber}")
    public PracticeFormPage verifyMobileNumber(String expectedNumber) {
        String actualValue = $("#userNumber").getValue();
        boolean isValid = actualValue.equals(expectedNumber);
        AllureLogger.logFieldValidation("Номер телефона", expectedNumber, actualValue, isValid);
        $("#userNumber").shouldHave(value(expectedNumber));
        return this;
    }

    @Step("Проверить дату рождения: {birthDate}")
    public PracticeFormPage verifyBirthDate(String expectedDate) {
        String actualValue = $("#dateOfBirthInput").getValue();
        boolean isValid = actualValue.equals(expectedDate);
        AllureLogger.logFieldValidation(
                "Дата рождения",
                expectedDate,
                actualValue,
                isValid
        );
        $("#dateOfBirthInput").shouldHave(value(expectedDate));
        return this;
    }


    @Step("Проверить пол: {expectedGender}")
    public PracticeFormPage verifyGender(String expectedGender) {
        String actualValue = $("input[name=gender]:checked + label").getText();
        boolean isValid = actualValue.equals(expectedGender);
        AllureLogger.logFieldValidation("Пол", expectedGender, actualValue, isValid);
        $("input[name=gender]:checked + label").shouldHave(text(expectedGender));
        return this;
    }

    @Step("Проверить хобби: {expectedHobbies}")
    public PracticeFormPage verifyHobbies(String... expectedHobbies) {
        for (String hobby : expectedHobbies) {
            String actualValue = $("input[type=checkbox]:checked + label").getText();
            boolean isValid = actualValue.contains(hobby);
            AllureLogger.logFieldValidation("Хобби", hobby, actualValue, isValid);
            $("input[type=checkbox]:checked + label").shouldHave(text(hobby));
        }
        return this;
    }

    @Step("Проверить предмет: {expectedSubject}")
    public PracticeFormPage verifySubject(String expectedSubject) {
        String actualValue = $(".subjects-auto-complete__multi-value__label").getText();
        boolean isValid = actualValue.equals(expectedSubject);
        AllureLogger.logFieldValidation("Предмет", expectedSubject, actualValue, isValid);
        $(".subjects-auto-complete__multi-value__label").shouldHave(text(expectedSubject));
        return this;
    }

    @Step("Проверить загрузку файла")
    public PracticeFormPage verifyPictureUploaded() {
        String actualValue = $("#uploadPicture").getValue();
        boolean isValid = !actualValue.isEmpty();
        AllureLogger.logFieldValidation("Загрузка файла", "Файл загружен", actualValue, isValid);
        $("#uploadPicture").shouldNotHave(value(""));
        return this;
    }

    @Step("Проверить адрес: {expectedAddress}")
    public PracticeFormPage verifyCurrentAddress(String expectedAddress) {
        String actualValue = $("#currentAddress").getValue();
        boolean isValid = actualValue.equals(expectedAddress);
        AllureLogger.logFieldValidation("Адрес", expectedAddress, actualValue, isValid);
        $("#currentAddress").shouldHave(value(expectedAddress));
        return this;
    }

    @Step("Проверить штат и город: {expectedState}, {expectedCity}")
    public PracticeFormPage verifyStateAndCity(String expectedState, String expectedCity) {
        String actualValue = $("#stateCity-wrapper").getText();
        boolean isValid = actualValue.contains(expectedState) && actualValue.contains(expectedCity);
        AllureLogger.logFieldValidation("Штат и город", 
            expectedState + " " + expectedCity, 
            actualValue, 
            isValid);
        $("#stateCity-wrapper").shouldHave(
                text(expectedState),
                text(expectedCity)
        );
        return this;
    }
}