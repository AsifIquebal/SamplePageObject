package automationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pageObjects.automationPractice.BaseClass;
import pageObjects.automationPractice.Common;
import utility.MyWrapper;

public class TestCase2 extends BaseClass {

    Common common;

    @Test
    public void NavigateToWomenEveningDressSection() throws InterruptedException {
        LaunchApplication();
        common = new Common();
        common.moveMouse(driver, common.WomenMenu);
        common.moveMouse(driver, common.Women_EveningDress);
        MyWrapper.click(driver,common.Women_EveningDress);
        Assert.assertEquals(driver.getTitle(),"Evening Dresses - My Store");
    }



    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }




}
