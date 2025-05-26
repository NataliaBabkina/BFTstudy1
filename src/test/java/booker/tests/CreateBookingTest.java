package booker.tests;

import booker.tests.BaseTest;
import booker.models.Booking;
import booker.models.BookingDates;
import booker.utils.TestHelper;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.qameta.allure.restassured.AllureRestAssured;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Epic("Booking API")
@DisplayName("Создание записи")
public class CreateBookingTest extends BaseTest {

    @Test
    @DisplayName("Создание книги и статус 200")
    @Severity(SeverityLevel.BLOCKER)
    void createBookingWithValidData() {
        Booking booking = TestHelper.createTestBooking();

        given()
                //.filter(new AllureRestAssured()
                        //.setRequestTemplate("http-request.ftl")
                        //.setResponseTemplate("http-response.ftl"))
                .contentType("application/json")
                .body(booking)
                .when()
                .post("/booking")
                .then()
                .statusCode(200)
                .body("bookingid", notNullValue())
                .body("booking.firstname", equalTo(booking.getFirstname()));

    }
}
