package pageObjects.mercury;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by user on 18-Apr-17.
 */
public class FlightFinderPage {

    WebDriver driver;

    public FlightFinderPage(WebDriver driver){
        this.driver = driver;
    }

    By oneWayRadioButton = By.xpath("//input[@value='oneway']");
    By passengers = By.xpath("//select[@name='passCount']");
    By fromPort = By.xpath("//select[@name='fromPort']");
    By toPort = By.xpath("//select[@name='toPort']");

    public FlightFinderPage clickOneWayRadioButton()
    {
        driver.findElement(oneWayRadioButton).click(); return this;
    }

    public FlightFinderPage selectPassengerCount(String value)
    {
        //driver.findElement(passengers).click();
        Select select = new Select(driver.findElement(passengers));
        select.selectByValue(value);
        return this;
    }

    public FlightFinderPage selectFromPort(String value)
    {
        //driver.findElement(fromPort).click();
        Select select = new Select(driver.findElement(fromPort));
        select.selectByValue(value);
        return this;
    }
}
