package automationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.automationPractice.*;

import java.util.Hashtable;
import java.util.List;


public class TestCase1 extends BaseClass {
    LoginPage loginPage;
    Common common;
    MyAccount myAccount;

    @Test
    public void openLoginPageTest(){
        LaunchApplication();
        loginPage = clickSignInLink();
        Assert.assertEquals(driver.getTitle(),"Login - My Store");
    }

    @Test(dependsOnMethods = "openLoginPageTest")
    public void loginTest(){
        loginPage
                .enterEmail("asu9421@gmail.com")
                .enterPassword("aut555")
                .clickOnSignInButton();
        Assert.assertEquals(driver.getTitle(),"My account - My Store");
    }

    String addressTitle = "AsusAddress";
    @Test(dependsOnMethods = "loginTest")
    public void AddAddress() {
        myAccount = new MyAccount(driver);
        MyAddresses myAddress = myAccount.ClickOnMyAddress();
        myAddress.clickOnAddNewAddress();
        myAddress
                .enterFirstName("Asif")
                .enterLastName("Sarkar")
                .enterAddress1("5th Avenue Street, North Dacota")
                .enterCity("Seattle")
                .SelectState(2)
                .enterPostcode("50001")
                .enterHomePhone("1234567890")
                .enterMobilePhone("1234567890")
                .enterAddressTitle(addressTitle);
        myAccount = myAddress.ClickOnSaveButton();
    }

    @Test(dependsOnMethods = "AddAddress")
    public void DeleteAddress(){
        myAccount.DeleteAddress1();
    }

    @Test(dependsOnMethods = "DeleteAddress")
    public void performSignOut(){
        common = new Common(driver);
        common.ClickOnSignOutLink();
        Assert.assertEquals(driver.getTitle(),"Login - My Store");
    }

    /*@Test
    public void failedTest(){
        driver.get("https://www.google.com");
        //getScreenShot("sample screen shot");
        Reporter.log("Hi Asif, this is from TestNGRelated Reporter Log");
        Assert.assertEquals("1","2");
    }*/

    //@Test
    public void testOnly(){
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        loginPage = new LoginPage(driver);
        loginPage
                .enterEmail("asu9421@gmail.com")
                .enterPassword("aut555")
                .clickOnSignInButton();
    }

    //@Test
    public void playGround(){
        Select select  = new Select(driver.findElement(By.id("1")));
        // all the options
        List<WebElement> allOptions = select.getOptions();
        // all selected options
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        // First selected option
        WebElement element = select.getFirstSelectedOption();
        select.selectByVisibleText("SelectMe");
        select.selectByIndex(1);
        select.selectByValue("value1");
        element.sendKeys("\\n");
    }


    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}

