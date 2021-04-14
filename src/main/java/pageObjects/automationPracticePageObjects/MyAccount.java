package pageObjects.automationPracticePageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.base.BasePage;
import utility.MyWrapper;

public class MyAccount extends BasePage {

    private By MyAddresses = By.xpath("//span[text()='My addresses']");
    private By deleteAddressButton1 = By.xpath("(//span[text()='Delete'])[1]");

    public MyAccount(WebDriver driver) {
        super(driver);
    }

    public MyAddresses ClickOnMyAddress() {
        MyWrapper.click(driver(), MyAddresses);
        return new MyAddresses(driver());
    }

    public MyAccount DeleteAddress1() {
        MyWrapper.click(driver(), deleteAddressButton1);
        Alert alert = driver().switchTo().alert();
        alert.accept();
        return this;
    }

}
