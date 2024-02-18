package apiRestassuredTest;

import hibernateHelper.Const;
import hibernateHelper.HibernateConnection;
import hibernateHelper.entityDBScheme.HouseDbWorker;
import hibernateHelper.entityDBScheme.PersonDbWorker;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.given;

public abstract class ApiTest {

    protected static HouseDbWorker houseDb = new HouseDbWorker();
    protected static PersonDbWorker personDb = new PersonDbWorker();

    @AfterAll
    public static void closeSessions() {
        HibernateConnection.killSession();
    }
    private static String token;

    @BeforeAll
    public static void init() {
        token = "bearer " + given()
                .body("{ \"username\": \"user@pflb.ru\",  \"password\": \"user\"}")
                .when()
                .contentType(ContentType.JSON)
                .post(Const.BASE_SERVER_URL + "/login")
                .then().extract().body().jsonPath().getString("access_token");
    }
}
