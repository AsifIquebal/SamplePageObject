package pageObjects.mercury;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

/**
 * Created by user on 09-Dec-16.
 */
public class BaseClass {

    public WebDriver driver;
    String baseURL, userName, passWord;

    public void readPropertiesFile() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src\\main\\java\\pageObjects\\mercury\\mercuryConfig.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);
        baseURL = properties.getProperty("url");
        userName = properties.getProperty("username");
        passWord = properties.getProperty("password");
    }

    @BeforeMethod
    @Parameters("browser")
    public void launchBrowser(@Optional("Chrome") String browser) {
        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
    }

    @AfterMethod
    public void getScreenShot(ITestResult result) throws IOException {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_hh.mm.ss");
        String formattedDate = formatter.format(date);
        if(!result.isSuccess()){
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String fileName = result.getMethod().getMethodName();
            String path = new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/test/java/Selenium/screenshots/";
            File destFile = new File(path + fileName + "_" + formattedDate+".png");
            System.out.println("Project Location Root: " + System.getProperty("user.dir"));
            //File destFile = new File("C:/Other/screenShots/" + fileName + "_" + formattedDate + ".png");
            System.out.println(destFile.getAbsolutePath());
            FileUtils.copyFile(scrFile, destFile, true);
            Reporter.setCurrentTestResult(result);
            Reporter.log("<a href='" + destFile.getCanonicalPath() + "'> <img src='" + destFile.getCanonicalPath() + "' height='100' width='100'/> </a>");
        }
        if(result.getStatus() == ITestResult.FAILURE){
            System.out.println("Another way to check: result.getStatus() == ITestResult.FAILURE" );
        }
        driver.quit();

    }

    public void getScreenShot(String name) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "src/test/java/Selenium/screenshots/";
            File destFile = new File((String) reportDirectory + name + "_" + formater.format(calendar.getTime()) + ".png");
            FileUtils.copyFile(scrFile, destFile);
            // This will help us to link the screen shot in testNG report
            Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*@AfterClass
    public void closeBrowser() {
        driver.quit();
    }*/
    /*@AfterMethod
    public void closeBrowser() {
        driver.quit();
    }*/

}
