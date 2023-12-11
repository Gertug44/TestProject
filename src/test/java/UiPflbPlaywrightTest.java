import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import entityScheme.*;

public class UiPflbPlaywrightTest extends UITestsPlaywright {

    @Test
    @DisplayName("Удаление дома")
    public void deleteHouseTest() {
        var houseEntity = houseDb.getFreeHouse();
        /*var deletedPage = new DeletePagePlaywright();
        deletedPage.openDeletePage();
        if (!deletedPage.deleteHouseById(houseEntity))
            fail( "Не удалось удалить объект");
        var checkDeleted = houseDb.isDeleted("id = "+houseEntity);
        assertTrue(checkDeleted, "Объект не удалился");*/
    }
}
