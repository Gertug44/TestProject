import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import entityScheme.*;

import pageHelper.CreateHousePageSelenide;
import pageHelper.Const;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UiPflbSelenideTests extends UiTestsSelenide {
    @Test
    @DisplayName("Создание дома")
    public void createHouseTest(){
        var createdHouseId = new CreateHousePageSelenide().createHouse();
        var houseEntity = houseDb.getOne("id = "+createdHouseId);
        assertTrue(houseEntity.equal(createdHouseId, Const.FLOOR_COUNT, (float) Const.PRICE),
                "Объект не создался или имеет отличные поля");
    }
}
