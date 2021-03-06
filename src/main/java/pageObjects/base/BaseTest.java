package pageObjects.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import pageObjects.automationPracticePageObjects.HomePage;
import pageObjects.automationPracticePageObjects.LoginPage;
import utility.MyWrapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.logging.Level;

public abstract class BaseTest {

    final Map<String, Object> chromePrefs = new HashMap<>();

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
    public void launchBrowser(@Optional("chrome") String browser) throws IOException, InterruptedException {
        String OS = System.getProperty("os.name").toLowerCase();
        log.info("Running on Platform: " + OS);
        if (browser.equalsIgnoreCase("chrome")) {
            if (OS.equals("linux")) {
                log.info("On Linux, getting Chromedriver file");
                ProcessBuilder builder = new ProcessBuilder();
                String pathToChromeDriver = Constants.CHROME_DRIVER_PATH_LINUX;
                log.info("driver path: " + pathToChromeDriver);
                builder.command("sh", "-c", "chmod +x '" + pathToChromeDriver + "'");
                Process process = builder.start();
                StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(), System.out::println);
                Executors.newSingleThreadExecutor().submit(streamGobbler);
                int exitCode = process.waitFor();
                assert exitCode == 0;
                System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
            } else {
                log.info("On Windows, getting Chromedriver file");
                System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH_WINDOWS);
            }
            driver = new ChromeDriver(OptionsManager.getChromeOptions());
        } else if (browser.equals("firefox")) {
            if (OS.equals("linux")) {
                log.info("On Linux, getting GeckoDriver file");
                ProcessBuilder builder = new ProcessBuilder();
                String pathToGeckoDriver = Constants.GECKO_DRIVER_PATH_LINUX;
                log.info("driver path: " + pathToGeckoDriver);
                builder.command("sh", "-c", "chmod +x '" + pathToGeckoDriver + "'");
                Process process = builder.start();
                StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(), System.out::println);
                Executors.newSingleThreadExecutor().submit(streamGobbler);
                int exitCode = process.waitFor();
                assert exitCode == 0;
                System.setProperty("webdriver.gecko.driver", pathToGeckoDriver);
            } else {
                System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH_WINDOWS);
            }
            driver = new FirefoxDriver(OptionsManager.getFirefoxOptions());
        } else {
            new RuntimeException("Didn't found Driver...");
        }
    }


    private static DesiredCapabilities getPerformanceLoggingCapabilities() {
        DesiredCapabilities caps = DesiredCapabilities.chrome();

        // Enable performance logging
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

        // Enable timeline tracing
        Map<String, Object> chromeOptions = new HashMap<String, Object>();
        Map<String, String> perfLoggingPrefs = new HashMap<String, String>();
        // Tracing categories, please note NO SPACE NEEDED after the commas
        perfLoggingPrefs.put("traceCategories", "blink.console,disabled-by-default-devtools.timeline");
        chromeOptions.put("perfLoggingPrefs", perfLoggingPrefs);
        //chromeOptions.put("debuggerAddress", "127.0.0.1:10134");
        caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        return caps;
    }

    // all the classes which extends this class will be able to use this method
    protected WebDriver driver() {
        return driver;
    }

    // Launch the Application
    public HomePage LaunchApplication() {
        driver().get(Constants.APP_URL);
        return new HomePage(driver());
    }

    public LoginPage clickOnSignInLink() {
        MyWrapper.click(driver(), signInLink);
        return new LoginPage(driver());
    }

    public void clickOnSignOutLink() {
        MyWrapper.click(driver(), signOut);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        System.out.println("chromePrefs------------------------");
        System.out.println(chromePrefs);
    }

    public static class StreamGobbler implements Runnable {
        private InputStream inputStream;
        private Consumer<String> consumer;

        public StreamGobbler(InputStream inputStream, Consumer<String> consumer) {
            this.inputStream = inputStream;
            this.consumer = consumer;
        }

        @Override
        public void run() {
            new BufferedReader(new InputStreamReader(inputStream)).lines().forEach(consumer);
        }
    }

}



