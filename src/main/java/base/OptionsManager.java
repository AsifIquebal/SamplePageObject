package base;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class OptionsManager {

    public static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);
        chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        /*Headless on Windows, Check periodically for any modification*/
        chromeOptions.setHeadless(false);
        /*If you are using chromedriver in headless mode on Linux platform the argument disable-gpu is crucial and mandatory.*/
        //options.addArguments("--headless","--disable-gpu");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        //options.setPageLoadTimeout();
        //options.setScriptTimeout();
        //options.setImplicitWaitTimeout();
        //disable automation info bar
        chromeOptions.addArguments("disable-infobars");
        // Start in Maximized mode
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--no-sandbox"); // Bypass OS security model
        chromeOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        chromeOptions.addArguments("allow-running-insecure-content");
        // set window size for better resolution and screen capture
        chromeOptions.addArguments("window-size=1200x600");
        //Exception exception = new Exception()
        chromeOptions.addArguments("perfLoggingPrefs");
        //options.setExperimentalOption("perfLoggingPrefs", chromePrefs);
        return chromeOptions;
    }

    public static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        //Accept Untrusted Certificates
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        //Use No Proxy Settings
        profile.setPreference("network.proxy.type", 0);
        //Set Firefox profile to capabilities
        firefoxOptions.setCapability(FirefoxDriver.PROFILE, profile);
        //firefoxOptions.addPreference();
        //
        firefoxOptions.setHeadless(false);
        return firefoxOptions;
    }

}
