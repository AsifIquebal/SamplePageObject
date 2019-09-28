package automationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;
import pageObjects.base.Constants;

import java.io.IOException;

public class TestCase3 {

    @Test
    public void test01() {
        String pathToGeckoDriver = Constants.GECKO_DRIVER_PATH_LINUX;

        /*ProcessBuilder builder = new ProcessBuilder();
        builder.command("sh", "-c", "chmod +x '" + pathToGeckoDriver + "'");

        Process process = builder.start();
        BaseTest.StreamGobbler streamGobbler = new BaseTest.StreamGobbler(process.getInputStream(), System.out::println);
        Executors.newSingleThreadExecutor().submit(streamGobbler);
        int exitCode = process.waitFor();
        assert exitCode == 0;*/

        FirefoxOptions firefoxOptions = new FirefoxOptions();

        System.setProperty("webdriver.gecko.driver", pathToGeckoDriver);

        WebDriver driver = new FirefoxDriver(firefoxOptions);
        driver.get("https://www.google.co.in");
        System.out.println(driver.getTitle());
    }

}
