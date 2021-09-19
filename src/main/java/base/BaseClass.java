package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import pageObjects.automationPracticePageObjects.LoginPage;
import utility.MyWrapper;

public class BaseClass {

    public WebDriver driver;
    public By WomenMenu = By.xpath("//a[@title='Women']");
    public By Women_EveningDress = By.xpath("//a[@title='Women']/..//a[@title='Evening Dresses']");
    By signInLink = By.xpath("//a[normalize-space()='Sign in']");
    private By signOut = By.xpath("//div/a[normalize-space()='Sign out']");

    // Launch the Application
    public void LaunchApplication() {
        driver.get("http://automationpractice.com");
    }

    public LoginPage clickOnSignInLink() {
        MyWrapper.click(driver, signInLink);
        return new LoginPage(driver);
    }

    public void clickOnSignOutLink() {
        MyWrapper.click(driver, signOut);
    }

    public void moveMouse(By by) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
        Thread.sleep(2000);
    }

    public void openWomenEveningDressMenu() {
        if (driver == null) {
            System.out.println("driver is null");
        } else {
            Actions actions = new Actions(driver);
            actions
                    .moveToElement(driver.findElement(WomenMenu))
                    .pause(2000)
                    .moveToElement(driver.findElement(Women_EveningDress))
                    .pause(2000)
                    .build()
                    .perform();
            MyWrapper.click(driver, Women_EveningDress);
        }
    }

    // Get Page Title
    public String getPageTitle() {
        return driver.getTitle();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
