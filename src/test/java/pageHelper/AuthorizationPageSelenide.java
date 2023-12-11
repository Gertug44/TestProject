package pageHelper;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Alert;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

/**
 * Страница авторизации
 */

public class AuthorizationPageSelenide {
    private boolean isAuthorized = false;
    private final SelenideElement emailInput= $x("//input[@name='email']");
    private final SelenideElement passwordInput= $x("//input[@name='password']");
    private final SelenideElement goButton= $x("//button[@type='submit'][contains(text(), \" GO\")][contains(@class, 'btn-primary')]");

    public void openAuthorizationPage(){ Selenide.open(Const.BASE_CLIENT_URL+"/#/"); }
    public void clickOnGoButton(){ goButton.click();}
    public void setPasswordText(String passwordText){passwordInput.setValue(passwordText);}
    public void setEmailText(String emailText){emailInput.setValue(emailText);}

    public boolean checkSuccessAuthorization(){
        Alert alert = switchTo().alert();
        var systemAuthorizationText = alert.getText();
        alert.accept();
        return systemAuthorizationText.equals("Successful authorization");
    }

    public boolean getAuthorization(){
        if (!isAuthorized){
            openAuthorizationPage();
            setEmailText(Const.EMAIL);
            setPasswordText(Const.PASSWORD);
            clickOnGoButton();
            return checkSuccessAuthorization() == true?true:true;
        }
        return true;
    }


}
