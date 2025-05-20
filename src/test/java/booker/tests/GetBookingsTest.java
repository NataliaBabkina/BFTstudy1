package booker.tests;

import booker.tests.BaseTest;
import booker.models.Booking;
import booker.models.BookingDates;
import booker.utils.TestHelper;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;



@Epic("Booking API")
@DisplayName("Получение записи")
public class GetBookingsTest extends BaseTest {

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
    @DisplayName("Получение записи по ID")
    @Severity(SeverityLevel.CRITICAL)
    void getBookingById() {
        given()
                .when()
                .get("/booking/" + bookingId)
                .then()
                .statusCode(200)
                .body("firstname", notNullValue())
                .body("lastname", notNullValue());
    }


    @Test
    @DisplayName("Получение записи по имени")
    @Severity(SeverityLevel.NORMAL)
    void filterBookingsByName() {
        given()
                .queryParam("firstname", "Test")
                .queryParam("lastname", "User")
                .when()
                .get("/booking")
                .then()
                .statusCode(200)
                .body("$", not(empty()));
    }
}
