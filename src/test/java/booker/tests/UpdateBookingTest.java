package booker.tests;

import booker.models.Booking;
import booker.utils.TestHelper;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Epic("Booking API")
@DisplayName ("Обновление записи")
public class UpdateBookingTest extends BaseTest {

    private static int bookingId;
    private static Booking testBooking;

    @BeforeAll
    static void setupTestData() {

        testBooking = TestHelper.createTestBooking();
        Response response = given()
                .contentType("application/json")
                .body(testBooking)
                .post("/booking");

        bookingId = response.jsonPath().getInt("bookingid");
    }

    @Test
    @DisplayName("Обновление записи")
    @Severity(SeverityLevel.CRITICAL)
    void updateBookingWithValidData() {

        Booking updatedBooking = TestHelper.createTestBooking();
        updatedBooking.setFirstname("UpdatedName");
        updatedBooking.setLastname("UpdatedLastName");
        updatedBooking.setTotalprice(200);

        given()
                .contentType("application/json")
                .header("Cookie", "token=" + token)
                .body(updatedBooking)
                .when()
                .put("/booking/" + bookingId)
                .then()
                .statusCode(200)
                .body("firstname", equalTo(updatedBooking.getFirstname()))
                .body("lastname", equalTo(updatedBooking.getLastname()))
                .body("totalprice", equalTo(updatedBooking.getTotalprice()));
    }
}
