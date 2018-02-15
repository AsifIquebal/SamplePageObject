package pageObjects.automationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utility.MyWrapper;

public class MyAddresses {
    public WebDriver driver;
    public MyAddresses(WebDriver driver){
        this.driver = driver;
    }

    private By addNewAddress = By.xpath("//span[text()='Add a new address']");
    public void clickOnAddNewAddress(){
        MyWrapper.click(driver, addNewAddress);
    }

    private By firstname = By.id("firstname");
    public MyAddresses enterFirstName(String string){
        MyWrapper.sendKeys(driver,firstname,string);
        return this;
    }

    private By lastname = By.id("lastname");
    public MyAddresses enterLastName(String string){
        MyWrapper.sendKeys(driver,lastname,string);
        return this;
    }

    private By address1 = By.id("address1");
    public MyAddresses enterAddress1(String string){
        MyWrapper.sendKeys(driver,address1,string);
        return this;
    }

    private By city = By.id("city");
    public MyAddresses enterCity(String string){
        MyWrapper.sendKeys(driver,city,string);
        return this;
    }

    private By StateDropDown = By.id("id_state");
    public MyAddresses SelectState(int index){
        MyWrapper.waitUntilElementExists(driver,StateDropDown);
        WebElement element = driver.findElement(StateDropDown);
        Select select = new Select(element);
        select.selectByIndex(index);
        return this;
    }

    private By postcode = By.id("postcode");
    public MyAddresses enterPostcode(String string) {
        MyWrapper.sendKeys(driver,postcode,string);
        return this;
    }

    private By phone = By.id("phone");
    public MyAddresses enterHomePhone(String string) {
        MyWrapper.sendKeys(driver,phone,string);
        return this;
    }

    private By phone_mobile = By.id("phone_mobile");
    public MyAddresses enterMobilePhone(String string) {
        MyWrapper.sendKeys(driver,phone_mobile,string);
        return this;
    }

    private By AddressTitle = By.id("alias");
    public MyAddresses enterAddressTitle(String string) {
        MyWrapper.sendKeys(driver,AddressTitle,string);
        return this;
    }

    private By SaveButton = By.xpath("//span[normalize-space()='Save']");
    public MyAccount ClickOnSaveButton(){
        MyWrapper.click(driver,SaveButton);
        return new MyAccount(driver);
    }

}
