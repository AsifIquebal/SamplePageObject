package automationPracticeParallel;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestCase3 extends TestBase {

    @Test(dataProvider = "data")
    public void test001(String username, String password) throws InterruptedException {
        if (username.equals("user2")) {
            throw new SkipException("Skipped");
        }
        Thread.sleep(2000);
        System.out.println(flag + ", Test with data: " + username + " and " + password + ", Thread: " + Thread.currentThread().getId());
    }

    //@Test(dataProvider = "data")
    public void test002(String[] strings) {
        System.out.println("What to do? ..." + getFlag());
        if (!getFlag().equals("run")) {
            throw new SkipException("Skipped");
        }
        //System.out.println("Test2...flag value: " + flag);
    }

}
