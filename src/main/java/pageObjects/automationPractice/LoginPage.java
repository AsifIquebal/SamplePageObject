package pageObjects.automationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.MyWrapper;

public class LoginPage{

    public WebDriver driver;

    By emailAddress = By.id("email");
    By password = By.id("passwd");
    By signInButton = By.xpath("//span[normalize-space()='Sign in']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage enterEmail(String uid) {
        MyWrapper.sendKeys(driver, emailAddress, uid);
        return this;
    }

    public LoginPage enterPassword(String pass) {
        MyWrapper.sendKeys(driver, password, pass);
        return this;
    }

    public MyAccount clickOnSignInButton() {
        MyWrapper.click(driver, signInButton);
        return new MyAccount(driver);
    }

    /*public void performLogin(String a, String b){
        driver.findElement(emailAddress).sendKeys(a);
        driver.findElement(password).sendKeys(b);
        driver.findElement(signInButton).click();
    }*/

}
