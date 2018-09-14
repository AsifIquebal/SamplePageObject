package automationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pageObjects.base.BaseTest;

import java.io.*;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class RandD extends BaseTest {

    /*WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }*/

    //@Test
    public void playGround() {
        Select select = new Select(driver().findElement(By.id("1")));
        // all the options
        List<WebElement> allOptions = select.getOptions();
        // all selected options
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        // First selected option
        WebElement element = select.getFirstSelectedOption();
        select.selectByVisibleText("SelectMe");
        select.selectByIndex(1);
        select.selectByValue("value1");
        element.sendKeys("\\n");
    }

    @Test
    public void systemPropertyTest() {
        log.info("Previous: ");
        //System.out.print("Previous : ");
        log.info(System.getProperty("java.runtime.version"));
        //System.out.println(System.getProperty("java.runtime.version" ));
        System.setProperty("java.runtime.version", "Java Runtime 1.6.0");
        // prints Java Runtime Version after property set
        log.info("New : ");
        //System.out.print("New : ");
        log.info(System.getProperty("java.runtime.version"));
        //System.out.println(System.getProperty("java.runtime.version" ));

    }

    @Test
    public void locators() {
        driver().get("https://www.actitime.com/free-online-trial");
        driver().findElement(new ByAll(By.className("form-input"), By.id("last-name"), By.name("lastName"))).sendKeys("Asif");
        Integer i = new Integer(99);
    }

    @Test
    public void shellCommand() throws IOException, InterruptedException {
        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
        ProcessBuilder builder = new ProcessBuilder();
        if (isWindows) {
            builder.command("cmd.exe", "/c", "dir");
        } else {
            builder.command("sh", "-c", "ls");
        }
        builder.directory(new File(System.getProperty("user.home")));
        Process process = builder.start();
        StreamGobbler streamGobbler =
                new StreamGobbler(process.getInputStream(), System.out::println);
        Executors.newSingleThreadExecutor().submit(streamGobbler);
        int exitCode = process.waitFor();
        assert exitCode == 0;
    }
    @Test
    public void shellCommandToSetPermission() throws IOException, InterruptedException {
        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
        ProcessBuilder builder = new ProcessBuilder();
        String pathToChromeDriver = System.getProperty("user.dir")+"/src/main/resources/drivers/chromedriver";
        System.out.println(pathToChromeDriver);
        if (isWindows) {
            builder.command("cmd.exe", "/c", "dir");
        } else {
            builder.command("sh", "-c","chmod +x '" + pathToChromeDriver+"'");
        }
        //builder.directory(new File(System.getProperty("user.home")));
        Process process = builder.start();
        StreamGobbler streamGobbler =
                new StreamGobbler(process.getInputStream(), System.out::println);
        Executors.newSingleThreadExecutor().submit(streamGobbler);
        int exitCode = process.waitFor();
        assert exitCode == 0;
    }
    //chmod +x '/home/asif/Desktop/Study/TeamCity/buildAgent/work/8c05eaa99dca520a/src/main/resources/drivers/chromedriver'
    private static class StreamGobbler implements Runnable {
        private InputStream inputStream;
        private Consumer<String> consumer;

        public StreamGobbler(InputStream inputStream, Consumer<String> consumer) {
            this.inputStream = inputStream;
            this.consumer = consumer;
        }

        @Override
        public void run() {
            new BufferedReader(new InputStreamReader(inputStream)).lines()
                    .forEach(consumer);
        }
    }

}


