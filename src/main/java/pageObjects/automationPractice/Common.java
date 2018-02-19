package pageObjects.automationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utility.MyWrapper;

public class Common {

    public WebDriver driver;

    /*public Common(WebDriver driver) {
        this.driver = driver;
    }*/

    // Menu
    public By WomenMenu = By.xpath("//a[@title='Women']");
    By DressesMenu = By.xpath("//a[@title='Dresses']");
    By TShirtsMenu = By.xpath("//a[@title='T-shirts']");
    By Women_CasualDress = By.xpath("//a[@title='Women']/..//a[@title='Casual Dresses']");
    public By Women_EveningDress = By.xpath("//a[@title='Women']/..//a[@title='Evening Dresses']");
    By Women_SummerDresses = By.xpath("//a[@title='Women']/..//a[@title='Summer Dresses']");

    public void moveMouse(WebDriver driver, By by) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
        Thread.sleep(2000);
    }

    // Sign Out link
    private By signOut = By.xpath("//div/a[normalize-space()='Sign out']");
    public void ClickOnSignOutLink(){
        MyWrapper.click(driver, signOut);
    }









}
