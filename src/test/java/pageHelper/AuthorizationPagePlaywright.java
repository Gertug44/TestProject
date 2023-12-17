package pageHelper;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;


public class AuthorizationPagePlaywright {
    private boolean isAuthorized = false;
    private Page page;
    //private final SelenideElement emailInput= page.locator(("//input[@name='email']");
    //private final SelenideElement passwordInput= $x("//input[@name='password']");
    //private final SelenideElement goButton= $x("//button[@type='submit'][contains(text(), \" GO\")][contains(@class, 'btn-primary')]");

    public AuthorizationPagePlaywright(Page page){
        this.page=page;
    }
    public void openAuthorizationPage(){
        page.navigate(Const.BASE_CLIENT_URL+"/#/");
    }
    public void clickOnGoButton(){
        Locator goButton =  page.locator("//button[@type='submit'][contains(text(), \" GO\")][contains(@class, 'btn-primary')]");
        initializeAlertAction();
        goButton.click();
    }
    public void setPasswordText(String passwordText){
        Locator passwordInput =  page.locator("//input[@name='password']");
        passwordInput.fill(passwordText);
    }
    public void setEmailText(String emailText){
        Locator emailInput =  page.locator("//input[@name='email']");
        emailInput.fill(emailText);
    }

    public void initializeAlertAction() {
        page.onceDialog(dialog -> {
            assert (dialog.message().equals("Successful authorization"));
            dialog.accept("OK");
        });
    }

    public boolean getAuthorization(){
        if (!isAuthorized){
            openAuthorizationPage();
            setEmailText(Const.EMAIL);
            setPasswordText(Const.PASSWORD);
            clickOnGoButton();
            return true;
        }
        return true;
    }
}
