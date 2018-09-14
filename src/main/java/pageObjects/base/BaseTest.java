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
import pageObjects.automationPractice.HomePage;
import pageObjects.automationPractice.LoginPage;
import utility.MyWrapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public abstract class BaseTest {

    public final static Logger log = LogManager.getLogger();
    // Sign In Link
    By signInLink = By.xpath("//a[normalize-space()='Sign in']");
    By DressesMenu = By.xpath("//a[@title='Dresses']");
    By TShirtsMenu = By.xpath("//a[@title='T-shirts']");
    By Women_CasualDress = By.xpath("//a[@title='Women']/..//a[@title='Casual Dresses']");
    By Women_SummerDresses = By.xpath("//a[@title='Women']/..//a[@title='Summer Dresses']");
    private WebDriver driver;
    // Sign Out link
    private By signOut = By.xpath("//div/a[normalize-space()='Sign out']");

    @BeforeClass
    @Parameters("browser")
    public void launchBrowser(@Optional("Chrome") String browser) throws IOException, InterruptedException {
        String OS = System.getProperty("os.name").toLowerCase();
        log.info("Running on Platform: " + OS);
        if (browser.equalsIgnoreCase("Chrome")) {
            if(OS.equals("linux")){
                System.out.println("On Linux, getting Chromedriver file");
                ProcessBuilder builder = new ProcessBuilder();
                String pathToChromeDriver = System.getProperty("user.dir")+"/src/main/resources/drivers/chromedriver";
                System.out.println(pathToChromeDriver);
                builder.command("sh", "-c","chmod +x '" + pathToChromeDriver+"'");
                Process process = builder.start();
                StreamGobbler streamGobbler =
                        new StreamGobbler(process.getInputStream(), System.out::println);
                Executors.newSingleThreadExecutor().submit(streamGobbler);
                int exitCode = process.waitFor();
                assert exitCode == 0;
                System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
            } else {
                System.out.println("On Windows, getting Chromedriver file");
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
            }
            ChromeOptions options = new ChromeOptions();
            //options.setAcceptInsecureCerts(true);
            //options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
            //disable automation info bar
            options.addArguments("disable-infobars");
            // Start in Maximized mode
            options.addArguments("--start-maximized");
            options.addArguments("--no-sandbox"); // Bypass OS security model
            options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
            options.addArguments("allow-running-insecure-content");
            /*Headless on Windows, Check periodically for any modification*/
            /*If you are using chromedriver in headless mode on Linux platform the argument disable-gpu is crucial and mandatory.*/
            //options.addArguments("--headless","--disable-gpu");
            //Exception exception = new Exception()
            driver = new ChromeDriver(options);
        } else if (browser.equals("firefox")) {
            if(OS.equals("linux")){
                System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver");
            } else {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
            }
            driver = new FirefoxDriver();
        }
    }

    // Menu-Sub Menu Navigation

    // all the classes which extends this class will be able to use this method
    protected WebDriver driver() {
        return driver;
    }

    // Launch the Application
    public HomePage LaunchApplication() {
        driver().get("http://automationpractice.com");
        return new HomePage(driver());
    }

    public LoginPage clickOnSignInLink() {
        MyWrapper.click(driver(), signInLink);
        return new LoginPage(driver());
    }

    public void clickOnSignOutLink() {
        MyWrapper.click(driver(), signOut);
    }

    public void moveMouse(By by) throws InterruptedException {
        Actions actions = new Actions(driver());
        actions.moveToElement(driver().findElement(by)).build().perform();
        Thread.sleep(2000);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private static class StreamGobbler implements Runnable {
        private InputStream inputStream;
        private Consumer<String> consumer;

        public StreamGobbler(InputStream inputStream, Consumer<String> consumer) {
            this.inputStream = inputStream;
            this.consumer = consumer;
        }

        @Override
        public void run() {
            new BufferedReader(new InputStreamReader(inputStream)).lines()
                    .forEach(consumer);
        }
    }

}


