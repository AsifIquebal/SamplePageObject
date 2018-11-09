package pageObjects.base;

class Constants {

    // drivers are bundled with project, please change as per need
    static final String CHROME_DRIVER_PATH_LINUX = System.getProperty("user.dir")+"/src/main/resources/drivers/chromedriver";
    static final String CHROME_DRIVER_PATH_WINDOWS = System.getProperty("user.dir")+"/src/main/resources/drivers/chromedriver.exe";

    static final String GECKO_DRIVER_PATH_LINUX = System.getProperty("user.dir")+"/src/main/resources/drivers/geckodriver";
    static final String GECKO_DRIVER_PATH_WINDOWS = System.getProperty("user.dir")+"/src/main/resources/drivers/geckodriver.exe";

    // Application URL
    static final String APP_URL = "http://automationpractice.com";
}
