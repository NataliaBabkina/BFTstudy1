package booker.tests;

import io.restassured.RestAssured;
import io.qameta.allure.restassured.AllureRestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    protected static final String BASE_URL = "https://restful-booker.herokuapp.com";
    protected static final String USERNAME = "admin";
    protected static final String PASSWORD = "password123";
    protected static String token;

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.filters(new AllureRestAssured());
        token = getAuthToken();
    }

    private static String getAuthToken() {
        return RestAssured.given()
                .contentType("application/json")
                .body(String.format("{\"username\":\"%s\",\"password\":\"%s\"}", USERNAME, PASSWORD))
                .post("/auth")
                .then()
                .extract()
                .path("token");
    }
}
