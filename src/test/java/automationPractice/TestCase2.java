package automationPractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.automationPractice.EveningDresses;
import pageObjects.automationPractice.HomePage;
import pageObjects.automationPractice.LoginPage;
import pageObjects.base.BaseTest;

public class TestCase2 extends BaseTest {

    HomePage homePage;
    EveningDresses eveningDresses;

    @Test
    public void NavigateToWomenEveningDressSection2() {
        homePage = LaunchApplication();
        log.info("Current URL: " + homePage.getURL());
        eveningDresses = homePage.openWomenEveningDressMenu();
        log.info("Current URL: " + eveningDresses.getURL());
        Assert.assertEquals(eveningDresses.getPageTitle(), "Evening Dresses - My Store");
    }



}
