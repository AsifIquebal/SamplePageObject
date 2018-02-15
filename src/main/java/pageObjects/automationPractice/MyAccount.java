package pageObjects.automationPractice;

import org.openqa.selenium.Alert;
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
        MyWrapper.click(driver, MyAddresses);
        return new MyAddresses(driver);
    }

    private By deleteAddressButton1 = By.xpath("(//span[text()='Delete'])[1]");
    public MyAccount DeleteAddress1(){
        MyWrapper.click(driver, deleteAddressButton1);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }

}
