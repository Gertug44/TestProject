import org.example.HibernateConnection;
import org.example.Person;
import org.example.PersonComparator;
import org.example.PersonEntity;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageHelper.TestsConst;

import java.util.Set;
import java.util.TreeSet;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiPflbTests {
    @AfterAll
    public static void closeSessions(){
        HibernateConnection.KillSession();
    }

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

    @Test
    @DisplayName("Проверка метода /users")
    public void getUsersTest(){
        Set<Person> users= new TreeSet<>(new PersonComparator());
        users.addAll( given()
                .header("accept","application/json")
                .when()
                .get(TestsConst.BASE_SERVER_URL +"/users")
                .then()
                .extract().body().jsonPath().getList("",  Person.class)
        );
        var iterator = users.iterator();
        boolean allEqual = HibernateConnection.session
                .createQuery("from PersonEntity p order by p.id ASC", PersonEntity.class)
                .stream().allMatch(
                        x-> {
                            var user = iterator.next();
                            return x.equal(user);
                        }
                );
        assertTrue(allEqual);
    }
}
