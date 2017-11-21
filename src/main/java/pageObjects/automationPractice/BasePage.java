package pageObjects.automationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.MyWrapper;

public class BasePage/*extends MyWrapper*/ {

    public WebDriver driver;
    By signInLink = By.xpath("//a[normalize-space()='Sign in']");

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage clickSignInLink(){
        MyWrapper.click(driver, signInLink);
        return new LoginPage(driver);
    }

}
