package entityScheme;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import pageHelper.Const;

import static io.restassured.RestAssured.given;

public abstract class ApiTest extends Test {
    private static String token;
    @BeforeAll
    public static void init(){
        token = "bearer "+given()
                .body("{ \"username\": \"user@pflb.ru\",  \"password\": \"user\"}")
                .when()
                .contentType(ContentType.JSON)
                .post(Const.BASE_SERVER_URL +"/login")
                .then().extract().body().jsonPath().getString("access_token");
    }
}
