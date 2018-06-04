package pageObjects.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import pageObjects.automationPractice.LoginPage;
import utility.MyWrapper;

public abstract class BaseTest {

    private WebDriver driver;
    public final static Logger log = LogManager.getLogger();

    @BeforeClass
    @Parameters("browser")
    public void launchBrowser(@Optional("Chrome") String browser) {
        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
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
            System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
    }

    // all the classes which extends this class will be able to use this method
    protected WebDriver driver(){
        return driver;
    }

    // Launch the Application
    public void LaunchApplication(){
        driver.get("http://automationpractice.com");
    }

    // Sign In Link
    By signInLink = By.xpath("//a[normalize-space()='Sign in']");
    public LoginPage clickOnSignInLink(){
        MyWrapper.click(driver, signInLink);
        return new LoginPage(driver);
    }

    // Sign Out link
    private By signOut = By.xpath("//div/a[normalize-space()='Sign out']");
    public void clickOnSignOutLink(){
        MyWrapper.click(driver, signOut);
    }

    // Menu-Sub Menu Navigation
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

    public void openWomenEveningDressMenu() {
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
    }

    @AfterClass
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

}


