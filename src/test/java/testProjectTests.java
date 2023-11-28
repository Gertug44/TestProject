import io.restassured.http.ContentType;

import org.example.HibernateConnection;
import org.example.PersonEntity;
import org.example.PersonEntityComparator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.TreeSet;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testProjectTests {
    private final static String URL = "http://77.50.236.203:4879";
    /*private static String token;
    @BeforeAll
    public static void init(){
        token = "bearer "+given()
                .body("{ \"username\": \"user@pflb.ru\",  \"password\": \"user\"}")
                .when()
                .contentType(ContentType.JSON)
                .post(URL+"/login")
                .then()
                .extract().body().jsonPath().getString("access_token");
    }*/

    @AfterAll
    public static void closeSessions(){
        HibernateConnection.KillSession();
    }

    @Test
    @DisplayName("Проверка метода /users")
    public void getUsersTest(){
        Set<PersonEntity> users= new TreeSet<>(new PersonEntityComparator());
        users.addAll(given()
                .header("accept","application/json")
                .when()
                .get(URL+"/users")
                .then()
                .extract().body().jsonPath().getList("", PersonEntity.class));
        var iterator = users.iterator();
        boolean allEqual = HibernateConnection.session
                .createQuery("from PersonEntity p order by p.id ASC", PersonEntity.class)
                .stream().allMatch(
                x-> {
                    var user = iterator.next();
                    return x.compareTo(user)==0;
                }
        );
        assertTrue(allEqual);
    }
}
