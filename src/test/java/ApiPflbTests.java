import org.example.entityScheme.Person;
import org.example.entityScheme.PersonComparator;
import org.example.entityScheme.PersonsEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageHelper.Const;

import java.util.Set;
import java.util.TreeSet;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;
import entityScheme.*;

public class ApiPflbTests extends ApiTest {
    @Test
    @DisplayName("Проверка метода /users")
    public void getUsersTest(){
        Set<Person> users= new TreeSet<>(new PersonComparator());
        users.addAll(given()
                .header("accept","application/json")
                .when()
                .get(Const.BASE_SERVER_URL +"/users")
                .then()
                .extract().body().jsonPath().getList("",  Person.class)
        );
        var iterator = users.iterator();
        boolean allEqual = personDb.getAll("id", "ASC").allMatch(
                x-> {
                    var user = iterator.next();
                    return PersonsEquals.isPersonsEqual(user, x);
                });
        assertTrue(allEqual);
    }
}
