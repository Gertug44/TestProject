package entityScheme;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.example.hibernateHelper.HibernateConnection;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import pageHelper.AuthorizationPagePlaywright;
import static org.junit.jupiter.api.Assertions.fail;

public abstract class UITestsPlaywright extends Test {
    protected static Page page;
    private static Playwright playwright;
    private static Browser browser;

    @BeforeAll
    public static void configureDriver(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        AuthorizationPagePlaywright authPage = new AuthorizationPagePlaywright(page);
        var authSuccess = authPage.getAuthorization();
        if (!authSuccess)
            fail("Не удалось выполнить вход");
        //authPage.getAuthorization(page);
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
