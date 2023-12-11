package pageHelper;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;


public class AuthorizationPagePlaywright {
    private boolean isAuthorized = false;
    //private final SelenideElement emailInput= page.locator(("//input[@name='email']");
    //private final SelenideElement passwordInput= $x("//input[@name='password']");
    //private final SelenideElement goButton= $x("//button[@type='submit'][contains(text(), \" GO\")][contains(@class, 'btn-primary')]");

    public void openAuthorizationPage(Page page){
        page.navigate(Const.BASE_CLIENT_URL+"/#/");
    }
    public void clickOnGoButton(Page page){
        Locator goButton =  page.locator("//button[@type='submit'][contains(text(), \" GO\")][contains(@class, 'btn-primary')]");
        goButton.click();
    }
    public void setPasswordText(Page page, String passwordText){
        Locator passwordInput =  page.locator("//input[@name='password']");
        passwordInput.fill(passwordText);
    }
    public void setEmailText(Page page, String emailText){
        Locator emailInput =  page.locator("//input[@name='email']");
        emailInput.fill(emailText);
    }

    public boolean checkSuccessAuthorization(Page page) {
        page.onDialog(dialog -> {
            assert (dialog.message() == "Successful authorization");
            dialog.accept();
        });
        return true;
    }

    public boolean getAuthorization(Page page){
        if (!isAuthorized){
            openAuthorizationPage(page);
            setEmailText(page, Const.EMAIL);
            setPasswordText(page, Const.PASSWORD);
            clickOnGoButton(page);
            return checkSuccessAuthorization(page);
        }
        return true;
    }
}
