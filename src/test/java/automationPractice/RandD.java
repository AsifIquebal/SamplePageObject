package automationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.testng.annotations.BeforeClass;
import pageObjects.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class RandD extends BaseTest{

    /*WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }*/

    //@Test
    public void playGround(){
        Select select  = new Select(driver().findElement(By.id("1")));
        // all the options
        List<WebElement> allOptions = select.getOptions();
        // all selected options
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        // First selected option
        WebElement element = select.getFirstSelectedOption();
        select.selectByVisibleText("SelectMe");
        select.selectByIndex(1);
        select.selectByValue("value1");
        element.sendKeys("\\n");
    }

    @Test
    public void systemPropertyTest(){
        log.info("Previous: ");
        //System.out.print("Previous : ");
        log.info(System.getProperty("java.runtime.version" ));
        //System.out.println(System.getProperty("java.runtime.version" ));
        System.setProperty("java.runtime.version", "Java Runtime 1.6.0");
        // prints Java Runtime Version after property set
        log.info("New : ");
        //System.out.print("New : ");
        log.info(System.getProperty("java.runtime.version" ));
        //System.out.println(System.getProperty("java.runtime.version" ));

    }

    @Test
    public void locators(){
        driver().get("https://www.actitime.com/free-online-trial");
        driver().findElement(new ByAll(By.className("form-input"), By.id("last-name"), By.name("lastName"))).sendKeys("Asif");
        Integer i = new Integer(99);
    }

}
