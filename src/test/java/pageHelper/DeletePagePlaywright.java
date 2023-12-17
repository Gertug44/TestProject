package pageHelper;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DeletePagePlaywright {
    private Page page;
    /*private final Locator deleteHouseInput= page.locator("//button[contains(text(),\"HOUSE\")]/..//input");
    private final Locator deleteHouseButton= page.locator("//button[contains(text(),\"HOUSE\")]");
    private final Locator deleteHouseStatusButton= page.locator("//button[contains(text(),\"HOUSE\")]/..//button[contains(text(),\"Status\")]");

    private final Locator deleteUserInput= page.locator("//button[contains(text(),\"USER\")]/..//input");
    private final Locator deleteUserButton= page.locator("//button[contains(text(),\"USER\")]");
    private final Locator deleteUserStatusButton= page.locator("//button[contains(text(),\"USER\")]/..//button[contains(text(),\"Status\")]");
    private final Locator deleteCarInput= page.locator("//button[contains(text(),\"CAR\")]/..//input");
    private final Locator deleteCarButton= page.locator("//button[contains(text(),\"CAR\")]");
    private final Locator deleteCarStatusButton= page.locator("//button[contains(text(),\"CAR\")]/..//button[contains(text(),\"Status\")]");*/
    public DeletePagePlaywright(Page page){
        this.page=page;
    }

    public void openDeletePage(){
        page.navigate(Const.BASE_CLIENT_URL+"/#/delete/all");
    }
    public Boolean deleteHouseById(Integer id){
        Locator deleteHouseInput= page.locator("//button[contains(text(),\"HOUSE\")]/..//input");
        Locator deleteHouseButton= page.locator("//button[contains(text(),\"HOUSE\")]");
        Locator deleteHouseStatusButton= page.locator("//button[contains(text(),\"HOUSE\")]/..//button[contains(text(),\"Status\")]");
        deleteHouseInput.fill(id.toString());
        deleteHouseButton.click();
        var deleteStatus = deleteHouseStatusButton.inputValue();
        return deleteStatus.substring(deleteStatus.lastIndexOf(" ") + 1).equals("204");
    }
    public Boolean deleteUserById(Integer id){
        Locator deleteUserInput= page.locator("//button[contains(text(),\"USER\")]/..//input");
        Locator deleteUserButton= page.locator("//button[contains(text(),\"USER\")]");
        Locator deleteUserStatusButton= page.locator("//button[contains(text(),\"USER\")]/..//button[contains(text(),\"Status\")]");
        deleteUserInput.fill(id.toString());
        deleteUserButton.click();
        var deleteStatus = deleteUserStatusButton.inputValue();
        return deleteStatus.substring(deleteStatus.lastIndexOf(" ") + 1).equals("204");
    }
    public Boolean deleteCarById(Integer id){
        Locator deleteCarInput= page.locator("//button[contains(text(),\"CAR\")]/..//input");
        Locator deleteCarButton= page.locator("//button[contains(text(),\"CAR\")]");
        Locator deleteCarStatusButton= page.locator("//button[contains(text(),\"CAR\")]/..//button[contains(text(),\"Status\")]");
        deleteCarInput.fill(id.toString());
        deleteCarButton.click();
        var deleteStatus = deleteCarStatusButton.inputValue();
        return deleteStatus.substring(deleteStatus.lastIndexOf(" ") + 1).equals("204");
    }
}
