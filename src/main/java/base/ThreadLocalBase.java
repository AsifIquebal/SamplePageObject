package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utility.MyWrapper;

public class ThreadLocalBase {

    private WebDriver driver;
    ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    public final static Logger log = LogManager.getLogger();
    By signInLink = By.xpath("//a[normalize-space()='Sign in']");
    private By signOut = By.xpath("//div/a[normalize-space()='Sign out']");

    @BeforeMethod
    @Parameters("browser")
    public void setDriverThreadLocal(@Optional("Chrome") String browser) {
        String OS = System.getProperty("os.name").toLowerCase();
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = setUpChrome();
        } else if (browser.equals("firefox")) {
            driver = setUpFirefox();
        }
        driverThreadLocal.set(driver);
    }

    private WebDriver setUpFirefox() {
        WebDriverManager.firefoxdriver().cachePath(System.getProperty("user.dir") + "/src/test/resources/drivers").setup();
        return new FirefoxDriver(OptionsManager.getFirefoxOptions());
    }

    private WebDriver setUpChrome() {
        WebDriverManager.chromedriver().cachePath(System.getProperty("user.dir") + "/src/test/resources/drivers").setup();
        return new ChromeDriver(OptionsManager.getChromeOptions());
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
        driverThreadLocal.remove();
    }

    public WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public HomePage launchApplication() {
        getDriver().get("http://automationpractice.com");
        return new HomePage(getDriver());
    }

    public LoginPage clickOnSignInLink() {
        MyWrapper.click(getDriver(), signInLink);
        return new LoginPage(getDriver());
    }

    public void clickOnSignOutLink() {
        MyWrapper.click(getDriver(), signOut);
    }

}
