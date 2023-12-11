package pageHelper;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CreateHousePageSelenide {
    private final SelenideElement floorsInput= $x("//input[@id='floor_send']");
    private final SelenideElement priceInput= $x("//input[@id='price_send']");
    private final SelenideElement createHouseButton= $x("//button[@type='button'][contains(text(), \"PUSH\")]");

    public void setFloorsText(Integer floors){
        floorsInput.click();
        floorsInput.setValue(floors.toString());
    }
    public void setPriceText(Integer price){
        priceInput.click();
        priceInput.setValue(price.toString());
    }
    public void createHouseClick(){ createHouseButton.click(); }
    public void openCreateHousePage(){
        Selenide.open(Const.BASE_CLIENT_URL+"/#/create/house");
        priceInput.shouldBe(Condition.visible);
        floorsInput.shouldBe(Condition.visible);
    }

    public String checkSuccessCreateHouse() {
        $x("//button[@type='button'][contains(text(), \"Successfully pushed\")]").shouldBe(Condition.visible);
        var newIdText = $x("//button[@type='button'][contains(@class, 'newId')]").text();
        return newIdText.substring(newIdText.lastIndexOf(" ") + 1);
    }

    public int createHouse(){
        openCreateHousePage();
        setFloorsText(Const.FLOOR_COUNT);
        setPriceText(Const.PRICE);
        createHouseClick();
        return Integer.parseInt(checkSuccessCreateHouse());
    }

}
