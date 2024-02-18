package apiRestassuredTest;

import hibernateHelper.Const;
import hibernateHelper.Person;
import hibernateHelper.PersonComparator;
import hibernateHelper.PersonsEquals;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.TreeSet;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiPflbTests extends ApiTest {
    @Step("Вызов метода users")
    private Set<Person> callUsesMethod() {
        Set<Person> users = new TreeSet<>(new PersonComparator());
        users.addAll(given()
                .header("accept", "application/json")
                .when()
                .get(Const.BASE_SERVER_URL + "/users")
                .then()
                .extract().response().body()
                .jsonPath()
                .getList("", Person.class)
        );
        return users;
    }

    @Step("Получение всех пользователей из БД и сранение результатов")
    private boolean getUsersFromDB(Set<Person> users){
        var iterator = users.iterator();
        return personDb.getAll("id", "ASC").stream().allMatch(
                x -> {
                    var user = iterator.next();
                    return PersonsEquals.isPersonsEqual(user, x);
                });
    }

    @SuppressWarnings("unchecked")
    @Test
    @DisplayName("Проверка метода /users")
    public void getUsersTest() {
        Set<Person> users = callUsesMethod();
        boolean allEqual = getUsersFromDB(users);
        Allure.step("Сравнить ответ метода и ответ БД");
        assertTrue(allEqual);
    }
}
