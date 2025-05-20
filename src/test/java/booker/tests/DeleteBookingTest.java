package booker.tests;

import booker.tests.BaseTest;
import booker.models.Booking;
import booker.models.BookingDates;
import booker.utils.TestHelper;

import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Booking API")
@DisplayName("Удаление записи")
public class DeleteBookingTest extends BaseTest {

    private static int bookingId;

    @BeforeAll
    static void setupTestData() {

        Booking testBooking = TestHelper.createTestBooking();
        Response response = given()
                .contentType("application/json")
                .body(testBooking)
                .post("/booking");

        bookingId = response.jsonPath().getInt("bookingid");
    }

    @Test
    @DisplayName("Удаление записи ")
    @Severity(SeverityLevel.CRITICAL)
    void deleteExistingBooking() {
        given()
                .header("Cookie", "token=" + token)
                .when()
                .delete("/booking/" + bookingId)
                .then()
                .statusCode(201);


        given()
                .get("/booking/" + bookingId)
                .then()
                .statusCode(404);
    }
}
