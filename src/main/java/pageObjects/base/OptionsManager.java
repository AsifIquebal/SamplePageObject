package pageObjects.base;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class OptionsManager {

    public Capabilities capabilities;

    public Capabilities getCapabilities (String browser) {
        if (browser.equalsIgnoreCase("firefox"))
            capabilities = getFirefoxOptions();
        else if(browser.equalsIgnoreCase("chrome"))
            capabilities = getChromeOptions();
        return capabilities;
    }

    public static ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        //options.setAcceptInsecureCerts(true);
        //options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        //disable automation info bar
        options.addArguments("disable-infobars");
        // Start in Maximized mode
        //options.addArguments("--start-maximized");
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("allow-running-insecure-content");
        /*Headless on Windows, Check periodically for any modification*/
        /*If you are using chromedriver in headless mode on Linux platform the argument disable-gpu is crucial and mandatory.*/
        //options.addArguments("--headless","--disable-gpu");
        // or options.setHeadless(true);
        // You should set window size for better resolution and screen capture
        //options.addArguments("window-size=1200x600");

        //Exception exception = new Exception()
        //options.addArguments("perfLoggingPrefs");
        //options.setExperimentalOption("perfLoggingPrefs", chromePrefs);
        return options;
    }

    public static FirefoxOptions getFirefoxOptions () {
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        //Accept Untrusted Certificates
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        //Use No Proxy Settings
        profile.setPreference("network.proxy.type", 0);
        //Set Firefox profile to capabilities
        options.setCapability(FirefoxDriver.PROFILE, profile);
        return options;
    }

}