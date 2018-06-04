package pageObjects.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pageObjects.automationPractice.HomePage;

public class ThreadLocalBase {

    WebDriver driver;

    ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    //@BeforeClass
    @BeforeMethod
    @Parameters("browser")
    public void setDriverThreadLocal(@Optional("Chrome") String browser) {
        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
            //options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driverThreadLocal.set(driver);
    }

    public WebDriver getDriver(){
        return driverThreadLocal.get();
    }

    //@AfterClass
    @AfterMethod
    public void tearDown(){
        getDriver().quit();
        driverThreadLocal.remove();
    }

    // Launch the Application
    public HomePage LaunchApplication(){
        getDriver().get("http://automationpractice.com");
        return new HomePage(getDriver());
    }

}
