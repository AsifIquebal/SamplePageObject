package automationPracticeParallel;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.automationPractice.HomePage;
import pageObjects.base.ThreadLocalBase;

public class TestCase1 extends ThreadLocalBase {
    HomePage homePage;


    @Test(dataProvider = "dp")
    public void simpleSearch(String string) {
        homePage = LaunchApplication();
        homePage
                .enterSearchQuery(string)
                .clickOnSearchInButton();
    }


    @DataProvider(name = "dp",parallel = true)
    public Object[][] getData(){
        return new Object[][]{
                {"Sari"},
                {"CHIFFON"}
        };
    }

    /*@Test(dataProvider = "dp1")
    public void simpleSearch1(String string) {
        System.out.println("" + Thread.currentThread().getName());
        homePage = LaunchApplication();
        homePage
                .enterSearchQuery(string)
                .clickOnSearchInButton();
    }

    @DataProvider(name = "dp1")
    public Object[][] getData1(){
        return new Object[][]{
                {"Sari"},
                {"CHIFFON"}
        };
    }*/
}


