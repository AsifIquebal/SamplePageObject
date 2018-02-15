package pageObjects.automationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utility.MyWrapper;

public class Common {

    public WebDriver driver;

    public Common(WebDriver driver) {
        this.driver = driver;
    }
    // Menu
    By WomenMenu = By.xpath("//a[@title='Women']");
    By DressesMenu = By.xpath("//a[@title='Dresses']");
    By TShirtsMenu = By.xpath("//a[@title='T-shirts']");
    By Women_CasualDress = By.xpath("//a[@title='Women']/..//a[@title='Casual Dresses']");
    By Women_SummerDresses = By.xpath("//a[@title='Women']/..//a[@title='Summer Dresses']");

    private void moveMouse(WebDriver driver, By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    // Sign Out link
    private By signOut = By.xpath("//div/a[normalize-space()='Sign out']");
    public void ClickOnSignOutLink(){
        MyWrapper.click(driver, signOut);
    }

}
