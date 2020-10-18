package pageObjects.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pageObjects.applicationPages.LoginPage;
import utility.MyWrapper;

public class BaseClass {

    public WebDriver driver;
    // Menu-Sub Menu Navigation
    // Menu
    public By WomenMenu = By.xpath("//a[@title='Women']");
    public By Women_EveningDress = By.xpath("//a[@title='Women']/..//a[@title='Evening Dresses']");
    // Sign In Link
    By signInLink = By.xpath("//a[normalize-space()='Sign in']");
    By DressesMenu = By.xpath("//a[@title='Dresses']");
    By TShirtsMenu = By.xpath("//a[@title='T-shirts']");
    By Women_CasualDress = By.xpath("//a[@title='Women']/..//a[@title='Casual Dresses']");
    By Women_SummerDresses = By.xpath("//a[@title='Women']/..//a[@title='Summer Dresses']");
    // Sign Out link
    private By signOut = By.xpath("//div/a[normalize-space()='Sign out']");

    @BeforeClass
    @Parameters("browser")
    public void launchBrowser(@Optional("firefox") String browser) {
        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
            //System.setProperty("webdriver.chrome.driver", "Selenium\\parentResource\\drivers\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            //options.setAcceptInsecureCerts(true);
            //options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
            //disable automation info bar
            options.addArguments("disable-infobars");
            // Start in Maximized mode
            options.addArguments("--start-maximized");
            /*Headless on Windows, Check periodically for any modification*/
            //options.addArguments("--headless","--disable-gpu");
            //Exception exception = new Exception()
            driver = new ChromeDriver(options);
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver");
            driver = new FirefoxDriver();
        }
    }

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


