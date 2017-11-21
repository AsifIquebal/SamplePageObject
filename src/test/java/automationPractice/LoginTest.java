package automationPractice;

import org.testng.annotations.Test;
import pageObjects.automationPractice.BaseClass;
import pageObjects.automationPractice.BasePage;
import pageObjects.automationPractice.LoginPage;


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

}
