import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.HibernateConnection;
import org.example.HouseEntity;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pageHelper.AuthorizationPage;
import pageHelper.CreateHousePage;
import pageHelper.DeletePage;
import pageHelper.TestsConst;

import static org.junit.jupiter.api.Assertions.*;

public class UiPflbTests {

    @BeforeAll
    public static void configureDriver(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser= "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;

    }

    @AfterAll
    public static void tearDown(){
        Selenide.closeWebDriver();
    }

    public Boolean Authorization() {
        var authorization = new AuthorizationPage();
        authorization.openAuthorizationPage();
        authorization.setEmailText(TestsConst.EMAIL);
        authorization.setPasswordText(TestsConst.PASSWORD);
        authorization.clickOnGoButton();
        return authorization.checkSuccessAuthorization();
    }

    public int CreateHouse(){
        var createHousePage = new CreateHousePage();
        createHousePage.openCreateHousePage();
        createHousePage.setPriceText(TestsConst.PRICE);
        createHousePage.setFloorsText(TestsConst.FLOOR_COUNT);
        createHousePage.createHouseClick();
        return Integer.parseInt(createHousePage.checkSuccessCreateHouse());
    }

    @Test
    @DisplayName("Создание дома")
    public void createHouseTest(){
        if (!Authorization())
            fail( "Не удалось выполнить вход");
        var createdHouseId = CreateHouse();
        var houseEntity = HibernateConnection.session
                .createQuery("from HouseEntity h where h.id = "+createdHouseId, HouseEntity.class).getSingleResult();
        assertTrue(houseEntity.equal(createdHouseId, TestsConst.FLOOR_COUNT, (float)TestsConst.PRICE),
                "Объект не создался или имеет отличные поля");
    }

    @Test
    @DisplayName("Удаление дома")
    public void deleteHouseTest() throws InterruptedException {
        /*if (!Authorization())
            assertTrue(false, "Не удалось выполнить вход");*/
        var deletedPage = new DeletePage();
        deletedPage.openDeletePage();
        var houseEntity = HibernateConnection.session
                .createQuery("select id from HouseEntity h " +
                                "where h.id not in (select h2.id from HouseEntity h2 join PersonEntity p on p.houseId =h2.id) order by RANDOM()",
                        Integer.class).setMaxResults(1).getSingleResult();
        if (!deletedPage.deleteHouseById(houseEntity))
            fail( "Не удалось удалить объект");
        Thread.sleep(1000);
        var checkDeleted = HibernateConnection.session
                .createQuery("from HouseEntity h where h.id = "+houseEntity,
                        HouseEntity.class).getResultList().size();
        assertEquals(checkDeleted,0, "Объект не удалился");
    }


}
