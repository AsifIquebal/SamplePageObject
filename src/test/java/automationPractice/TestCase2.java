package automationPractice;

import base.ThreadLocalBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.EveningDresses;
import pageObjects.HomePage;

public class TestCase2 extends ThreadLocalBase {

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

     /*@Test
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
    }*/

}
