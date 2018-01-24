package pageObjects.automationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MenuPage {

    By WomenMenu = By.xpath("//a[@title='Women']");
    By DressesMenu = By.xpath("//a[@title='Dresses']");
    By TShirtsMenu = By.xpath("//a[@title='T-shirts']");

    By Women_CasualDress = By.xpath("//a[@title='Women']/..//a[@title='Casual Dresses']");
    By Women_SummerDresses = By.xpath("//a[@title='Women']/..//a[@title='Summer Dresses']");


    private void moveMouse(WebDriver driver, By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }


    /*@Test
    public void testBrodocWithoutMemberOrProspectIdentified() {
        processLogon();
        MemberIdentificationPage page = openMemberIdentificationPage();
        page = page.getMenuElement().clickOnMenu(LuceneSearchPage.URL, LuceneSearchPage.class);
        page.hasInfoMessage();
        page.withNameFilter("mestachs").search().getResults().hasResults();
    }



    public  T clickOnMenu(String path, Class pageClassToProxy) {
        clickOnMenu(path);
        return PageFactory.initElements(getDriver(), pageClassToProxy);
    }*/

    public Class clickOnMenu(WebDriver driver, By by, Class pageClassToProxy) throws ClassNotFoundException {
        //pageClassToProxy c1=  pageClassToProxy.getClass();
        Class c = Class.forName(pageClassToProxy.getName());
        return c;
    }
    /*public T Login<T>(string email, string password)
    {
        return (T)Activator.CreateInstance(typeof(T), base.Driver);
    }*/







}
