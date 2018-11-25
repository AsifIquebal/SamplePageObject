package automationPracticeParallel;

import org.testng.annotations.Test;

public class TestCase2 {
    private String username;
    private String password;

    public TestCase2(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Test(threadPoolSize = 10, dataProviderClass = TestFactory.class)
    public void firstTest() throws InterruptedException {
        System.out.println("Getting Ready...");
        Thread.sleep(5000);
        System.out.println("Test with data: "+username+" and "+password + ", Thread: " + Thread.currentThread().getId());
        System.out.println("Done...");
    }

}
