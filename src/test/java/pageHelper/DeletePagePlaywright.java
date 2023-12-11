package pageHelper;

public class DeletePagePlaywright {
    /*private final SelenideElement deleteHouseInput= $x("//button[contains(text(),\"HOUSE\")]/..//input");
    private final SelenideElement deleteHouseButton= $x("//button[contains(text(),\"HOUSE\")]");
    private final SelenideElement deleteHouseStatusButton= $x("//button[contains(text(),\"HOUSE\")]/..//button[contains(text(),\"Status\")]");

    private final SelenideElement deleteUserInput= $x("//button[contains(text(),\"USER\")]/..//input");
    private final SelenideElement deleteUserButton= $x("//button[contains(text(),\"USER\")]");
    private final SelenideElement deleteUserStatusButton= $x("//button[contains(text(),\"USER\")]/..//button[contains(text(),\"Status\")]");
    private final SelenideElement deleteCarInput= $x("//button[contains(text(),\"CAR\")]/..//input");
    private final SelenideElement deleteCarButton= $x("//button[contains(text(),\"CAR\")]");
    private final SelenideElement deleteCarStatusButton= $x("//button[contains(text(),\"CAR\")]/..//button[contains(text(),\"Status\")]");

    public void openDeletePage(){
        Selenide.open(Const.BASE_CLIENT_URL+"/#/delete/all");
        deleteHouseInput.shouldBe(Condition.visible);
        deleteUserInput.shouldBe(Condition.visible);
        deleteCarInput.shouldBe(Condition.visible);
    }
    public Boolean deleteHouseById(Integer id){
        deleteHouseInput.setValue(id.toString());
        deleteHouseButton.click();
        var deleteStatus = deleteHouseStatusButton.text();
        return deleteStatus.substring(deleteStatus.lastIndexOf(" ") + 1).equals("204");
    }
    public Boolean deleteUserById(Integer id){
        deleteUserInput.setValue(id.toString());
        deleteUserButton.click();
        var deleteStatus = deleteUserStatusButton.text();
        return deleteStatus.substring(deleteStatus.lastIndexOf(" ") + 1).equals("204");
    }
    public Boolean deleteCarById(Integer id){
        deleteCarInput.setValue(id.toString());
        deleteCarButton.click();
        var deleteStatus = deleteCarStatusButton.text();
        return deleteStatus.substring(deleteStatus.lastIndexOf(" ") + 1).equals("204");
    }*/
}
