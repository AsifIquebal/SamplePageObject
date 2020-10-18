package pageObjects.applicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageObjects.base.BasePage;
import utility.MyWrapper;

public class MyAddresses extends BasePage {

    private By addNewAddress = By.xpath("//span[text()='Add a new address']");
    private By firstname = By.id("firstname");
    private By lastname = By.id("lastname");
    private By address1 = By.id("address1");
    private By city = By.id("city");
    private By StateDropDown = By.id("id_state");
    private By postcode = By.id("postcode");
    private By phone = By.id("phone");
    private By phone_mobile = By.id("phone_mobile");
    private By AddressTitle = By.id("alias");
    private By SaveButton = By.xpath("//span[normalize-space()='Save']");

    public MyAddresses(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddNewAddress() {
        MyWrapper.click(driver(), addNewAddress);
    }

    public MyAddresses enterFirstName(String string) {
        MyWrapper.sendKeys(driver(), firstname, string);
        return this;
    }

    public MyAddresses enterLastName(String string) {
        MyWrapper.sendKeys(driver(), lastname, string);
        return this;
    }

    public MyAddresses enterAddress1(String string) {
        MyWrapper.sendKeys(driver(), address1, string);
        return this;
    }

    public MyAddresses enterCity(String string) {
        MyWrapper.sendKeys(driver(), city, string);
        return this;
    }

    public MyAddresses SelectState(int index) {
        MyWrapper.waitUntilElementExists(driver(), StateDropDown);
        WebElement element = driver().findElement(StateDropDown);
        Select select = new Select(element);
        select.selectByIndex(index);
        return this;
    }

    public MyAddresses enterPostcode(String string) {
        MyWrapper.sendKeys(driver(), postcode, string);
        return this;
    }

    public MyAddresses enterHomePhone(String string) {
        MyWrapper.sendKeys(driver(), phone, string);
        return this;
    }

    public MyAddresses enterMobilePhone(String string) {
        MyWrapper.sendKeys(driver(), phone_mobile, string);
        return this;
    }

    public MyAddresses enterAddressTitle(String string) {
        MyWrapper.sendKeys(driver(), AddressTitle, string);
        return this;
    }

    public MyAccount ClickOnSaveButton() {
        MyWrapper.click(driver(), SaveButton);
        return new MyAccount(driver());
    }

}
