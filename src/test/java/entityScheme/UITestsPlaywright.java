package entityScheme;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.example.hibernateHelper.HibernateConnection;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import pageHelper.AuthorizationPagePlaywright;

import static org.junit.jupiter.api.Assertions.fail;

public abstract class UITestsPlaywright extends Test {
    protected static AuthorizationPagePlaywright authPage = new AuthorizationPagePlaywright();
    protected static Page page;
    private static Playwright playwright;
    private  static Browser browser;

    @BeforeAll
    public static void configureDriver(){
        playwright = Playwright.create();
        browser = playwright.webkit().launch();
        page = browser.newPage();
        /*if (authPage.getAuthorization(page))
            fail("Не удалось выполнить вход");*/
        authPage.getAuthorization(page);
    }

    private static void tearDown(){
        page.close();
        browser.close();
        playwright.close();
    }

    @AfterAll
    public static void closeSessions(){
        HibernateConnection.killSession();
        tearDown();
    }
}
