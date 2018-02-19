package pageObjects.automationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pageObjects.base.BaseClass;
import utility.MyWrapper;

public class Common{

    //public WebDriver driver;

    /*// Menu
    public By WomenMenu = By.xpath("//a[@title='Women']");
    By DressesMenu = By.xpath("//a[@title='Dresses']");
    By TShirtsMenu = By.xpath("//a[@title='T-shirts']");
    By Women_CasualDress = By.xpath("//a[@title='Women']/..//a[@title='Casual Dresses']");
    public By Women_EveningDress = By.xpath("//a[@title='Women']/..//a[@title='Evening Dresses']");
    By Women_SummerDresses = By.xpath("//a[@title='Women']/..//a[@title='Summer Dresses']");

    public void moveMouse(By by) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
        Thread.sleep(2000);
    }

    public void openWomenEveningDressMenu(WebDriver driver) {
        if(driver==null){
            System.out.println("driver is null");
        }
        else {
            Actions actions = new Actions(driver);
            actions
                    .moveToElement(driver.findElement(WomenMenu))
                    .pause(2000)
                    .moveToElement(driver.findElement(Women_EveningDress))
                    .pause(2000)
                    .build()
                    .perform();
            MyWrapper.click(driver,Women_EveningDress);
        }
    }*/



}
