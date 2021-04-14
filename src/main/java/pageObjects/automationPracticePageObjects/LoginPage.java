package pageObjects.automationPracticePageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.base.BasePage;
import utility.MyWrapper;

public class LoginPage extends BasePage {

    By emailAddress = By.id("email");
    By password = By.id("passwd");
    By signInButton = By.xpath("//span[normalize-space()='Sign in']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterEmail(String uid) {
        MyWrapper.sendKeys(driver(), emailAddress, uid);
        return this;
    }

    public LoginPage enterPassword(String pass) {
        MyWrapper.sendKeys(driver(), password, pass);
        return this;
    }

    public MyAccount clickOnSignInButton() {
        MyWrapper.click(driver(), signInButton);
        return new MyAccount(driver());
    }

}
