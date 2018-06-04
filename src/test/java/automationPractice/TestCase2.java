package automationPractice;

import pageObjects.automationPractice.LoginPage;
import pageObjects.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2 extends BaseTest {

    LoginPage loginPage;

    @Test
    public void NavigateToWomenEveningDressSection() throws InterruptedException {
        // will work when menus is in common class
        /*LaunchApplication();
        common = new Common();
        common.openWomenEveningDressMenu(driver);*/
        /*Women women = new Women(driver);
        women.openEveningDressSection();
        Assert.assertEquals(getPageTitle(),"Evening Dresses - My Store");*/
    }

    @Test
    public void NavigateToWomenEveningDressSection2() throws InterruptedException {
        LaunchApplication();
        openWomenEveningDressMenu();
        Assert.assertEquals(loginPage.getPageTitle(), "Evening Dresses - My Store");
    }


}
