package pageObjects.automationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.MyWrapper;

public class MyAccount {
    public WebDriver driver;

    public MyAccount (WebDriver driver) {
        this.driver = driver;
    }

    private By MyAddresses = By.xpath("//span[text()='My addresses']");
    public MyAddresses ClickOnMyAddress(){
        MyWrapper.click(driver, MyAddresses);//Addresses - My Store
        return new MyAddresses(driver);
    }

}
