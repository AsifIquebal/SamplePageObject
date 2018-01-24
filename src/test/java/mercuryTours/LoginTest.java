package mercuryTours;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageObjects.mercury.BaseClass;
import pageObjects.mercury.FlightFinderPage;
import pageObjects.mercury.LoginPage;


public class LoginTest extends BaseClass {

    @Test
    public void testLogin() throws InterruptedException {
        // http://newtours.demoaut.com
        driver.get("http://newtours.demoaut.com/mercurysignon.php");
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .enterUserName("a")
                .enterPassword("a");
        FlightFinderPage flightFinderPage = loginPage.clickOnLoginButton();
        Thread.sleep(5000);
        flightFinderPage
                .clickOneWayRadioButton()
                .selectPassengerCount("2")
                .selectFromPort("London");
    }

    @Test
    public void failedTest(){
        driver.get("https://www.google.com");
        //getScreenShot("sample screen shot");
        Reporter.log("Hi Asif, this is from TestNGRelated Reporter Log");
        Assert.assertEquals("1","2");
    }

}
































