import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import entityScheme.*;
import pageHelper.DeletePagePlaywright;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class UiPflbPlaywrightTest extends UITestsPlaywright {

    @Test
    @DisplayName("Удаление дома")
    public void deleteHouseTest() throws InterruptedException {
        var houseEntity = houseDb.getFreeHouse();
        var deletedPage = new DeletePagePlaywright(page);
        deletedPage.openDeletePage();
        if (!deletedPage.deleteHouseById(houseEntity))
            fail( "Не удалось удалить объект");
        var checkDeleted = houseDb.isDeleted("id = "+houseEntity);
        assertTrue(checkDeleted, "Объект не удалился");
    }
}
