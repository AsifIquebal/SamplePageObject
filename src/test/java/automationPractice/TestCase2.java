package automationPractice;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.EveningDresses;
import pageObjects.HomePage;
import base.BaseTest;
import base.Constants;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class TestCase2 extends BaseTest {

    HomePage homePage;
    EveningDresses eveningDresses;

    @Test
    public void NavigateToWomenEveningDressSection2() {
        homePage = launchApplication();
        log.info("Current URL: " + homePage.getURL());
        eveningDresses = homePage.openWomenEveningDressMenu();
        log.info("Current URL: " + eveningDresses.getURL());
        Assert.assertEquals(eveningDresses.getPageTitle(), "Evening Dresses - My Store");
    }

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

    @Test
    public void playWithWindowSize() {
        homePage = launchApplication();
        log.info("Default Window size at Launch: " + driver().manage().window().getSize());
        driver().manage().window().maximize();
        log.info("Browser window when Maximized: " + driver().manage().window().getSize());
        driver().manage().window().fullscreen();
        log.info("Browser window when FulllScreened: " + driver().manage().window().getSize());
        //  A maximized window is not the same as a fullscreen window.
        //  When maximized, the title bar etc. of the window is still displayed.
        //  In fullscreen mode, the title bar is not displayed.
        //  Try pressing F11 when you use Chrome, that shows you what fullscreen mode looks like.
    }

    @Test
    public void runHeadLessAndGetScreenShot() throws IOException {
        homePage = launchApplication();
        driver().manage().window().fullscreen();
        File srcFile = ((TakesScreenshot) driver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("sampleSS.png"));
        // using AShot
        Screenshot screenshot = new AShot().takeScreenshot(driver());
        ImageIO.write(screenshot.getImage(), "PNG", new File("aShot1.png"));
        new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(1000))
                .takeScreenshot(driver());
        ImageIO.write(screenshot.getImage(), "PNG", new File("aShot2.png"));
    }

}
