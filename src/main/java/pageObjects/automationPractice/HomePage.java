package pageObjects.automationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.base.BasePage;
import utility.MyWrapper;

public class HomePage extends BasePage {

    private final By searchBox = By.id("search_query_top");
    private final By searchButton = By.name("submit_search");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage enterSearchQuery(String string) {
        MyWrapper.sendKeys(driver(), searchBox, string);
        return this;
    }

    public HomePage clickOnSearchInButton() {
        MyWrapper.click(driver(), searchButton);
        return this;
    }

}
