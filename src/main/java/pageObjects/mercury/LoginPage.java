package pageObjects.mercury;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.MyWrapper;

public class LoginPage extends MyWrapper {

    public WebDriver driver;

    By userName = By.xpath("//input[@name='userName']");
    By password = By.xpath("//input[@name='password']");
    By loginButton = By.xpath("//input[@name='login']");
    By loginButtonFalse = By.xpath("//input[@name='login123']");

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public LoginPage enterUserName(String uid)
    {
        MyWrapper.sendKeys(driver, userName, uid);
        return this;
    }

    public LoginPage enterPassword(String pass)
    {
        MyWrapper.sendKeys(driver, password, pass);
        return this;
    }

    public FlightFinderPage clickOnLoginButton()
    {
        MyWrapper.click(driver, loginButton);
        return new FlightFinderPage(driver);
    }
}
