package pageObjects.automationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utility.MyWrapper;

/**
 * Created by user on 09-Dec-16.
 */
public class BaseClass {

    public WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void launchBrowser(@Optional("Chrome") String browser) {
        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            //options.setAcceptInsecureCerts(true);
            //options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
            //disable automation info bar
            options.addArguments("disable-infobars");
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);

        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
    }

    By signInLink = By.xpath("//a[normalize-space()='Sign in']");

    /*public BaseClass(WebDriver driver){
        this.driver = driver;
    }*/

    public void LaunchApplication(){
        driver.get("http://automationpractice.com");
    }
    public LoginPage clickSignInLink(){
        MyWrapper.click(driver, signInLink);
        return new LoginPage(driver);
    }


}


