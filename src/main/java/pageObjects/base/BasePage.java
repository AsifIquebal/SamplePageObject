package pageObjects.base;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriver driver() {
        return driver;
    }


    // Get Page Title
    public String getPageTitle() {
        return driver.getTitle();
    }

    // Get Page URL
    public String getURL(){
        return driver().getCurrentUrl();
    }

}


