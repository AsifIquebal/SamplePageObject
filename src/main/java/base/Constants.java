package base;

public class Constants {

    // drivers are bundled with project, please change as per need
    public static final String CHROME_DRIVER_PATH_LINUX = System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver";
    public static final String CHROME_DRIVER_PATH_WINDOWS = System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe";

    public static final String GECKO_DRIVER_PATH_LINUX = System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver";
    static final String GECKO_DRIVER_PATH_WINDOWS = System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver.exe";

    // Application URL
    static final String APP_URL = "http://automationpractice.com";
}
