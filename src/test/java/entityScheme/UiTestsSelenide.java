package entityScheme;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.hibernateHelper.HibernateConnection;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import pageHelper.AuthorizationPageSelenide;

import static org.junit.jupiter.api.Assertions.fail;

public abstract class UiTestsSelenide extends Test {
    public static AuthorizationPageSelenide authPage = new AuthorizationPageSelenide();

    @BeforeAll
    public static void configureDriver(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser= "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        //if (authPage.getAuthorization())
            //fail("Не удалось выполнить вход");
        authPage.getAuthorization();
    }

    private static void tearDown(){Selenide.closeWebDriver();}

    @AfterAll
    public static void closeSessions(){
        HibernateConnection.killSession();
        tearDown();
    }
}
