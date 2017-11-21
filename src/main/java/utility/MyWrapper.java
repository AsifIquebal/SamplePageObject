package utility;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class MyWrapper {
    private static final int waitTime = 15;

    public static void sendKeys(WebDriver driver, By by, String valueToType) {
        try {
            new WebDriverWait(driver, waitTime).until(ExpectedConditions.visibilityOfElementLocated(by));
            JavaScriptUtils.scrollIntoView(driver.findElement(by), driver);
            driver.findElement(by).clear();
            driver.findElement(by).sendKeys(valueToType);
        } catch (NoSuchElementException ex) {
            // when(ex is NoSuchElementException || ex is WebDriverTimeoutException)
            //ExtentTest test = ScenarioContext.Current.Get < ExtentTest > ();
            //test.Error("Could not perform SendKeys on element identified by " + by.ToString() + " after " + Constants.DefaultTimeout.ToString() + " seconds", MediaEntityBuilder.CreateScreenCaptureFromPath(ReportingMethods.CreateScreenshot(driver)).Build());
            System.out.println("Could not perform SendKeys on element identified by " + by.toString());
            Assert.fail();
        } catch (Exception ex) {
            //when(ex is StaleElementReferenceException)
            // find element again and retry
            //new WebDriverWait(driver, TimeSpan.FromSeconds(Constants.DefaultTimeout)).Until(ExpectedConditions.ElementIsVisible(by));
            new WebDriverWait(driver, waitTime).until(ExpectedConditions.visibilityOfElementLocated(by));
            JavaScriptUtils.scrollIntoView(driver.findElement(by), driver);
            driver.findElement(by).clear();
            driver.findElement(by).sendKeys(valueToType);
        }
    }

    public static void click(WebDriver driver, By by) {
        try {
            WebDriverWait mw = new WebDriverWait(driver, waitTime);
            mw.until(ExpectedConditions.visibilityOfElementLocated(by));
            JavaScriptUtils.scrollIntoView(driver.findElement(by), driver);
            driver.findElement(by).click();
        } catch (NoSuchElementException ex) {
            System.out.println("Could not perform SendKeys on element identified by " + by.toString());
            Assert.fail();
        } catch (Exception ex) {
            new WebDriverWait(driver, waitTime).until(ExpectedConditions.visibilityOfElementLocated(by));
            JavaScriptUtils.scrollIntoView(driver.findElement(by), driver);
            driver.findElement(by).click();
        }
    }

    public static WebElement waitUntilElementExists(WebDriver driver, final By by) {

        FluentWait<WebDriver> my_wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.MICROSECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement my_element = my_wait
                .until(new Function<WebDriver, WebElement>() {
                    @Override
                    public WebElement apply(WebDriver driver) {
                        return (driver.findElement(by));
                        //return driver.findElement(By.id(element_identifier_id));
                    }
                });
        return my_element;
    }

    public static WebDriverWait waitExplicit(WebDriver driver, By by){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return wait;
    }

    public static WebDriverWait waitExplicit(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
        return wait;
    }
}
