package automationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pageObjects.automationPractice.BaseClass;
import pageObjects.automationPractice.BasePage;
import pageObjects.automationPractice.LoginPage;

import java.util.Hashtable;
import java.util.List;


public class LoginTest extends BaseClass {

    BasePage basePage;
    LoginPage loginPage;

    /*@Test
    public void openLoginPageTest(){
        driver.get("http://automationpractice.com");
        basePage = new BasePage(driver);
        loginPage = basePage.clickSignInLink();
        Assert.assertEquals(driver.getTitle(),"Login - My Store");
    }

    @Test(dependsOnMethods = "openLoginPageTest")
    public void loginTest(){
        loginPage
                .enterEmail("asu9421@gmail.com")
                .enterPassword("aut555")
                .clickOnSignInButton();
        Assert.assertEquals(driver.getTitle(),"My account - My Store");
    }*/

    /*@Test
    public void failedTest(){
        driver.get("https://www.google.com");
        //getScreenShot("sample screen shot");
        Reporter.log("Hi Asif, this is from TestNGRelated Reporter Log");
        Assert.assertEquals("1","2");
    }*/

    @Test
    public void testOnly(){
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        loginPage = new LoginPage(driver);
        loginPage
                .enterEmail("asu9421@gmail.com")
                .enterPassword("aut555")
                .clickOnSignInButton();


    }

    @Test
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
    }


}


