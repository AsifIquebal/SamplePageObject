package automationPracticeParallel;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class TestFactory {

    @Factory(dataProvider = "data")
    public Object[] createInstances(String username, String password) {
        return new Object[]{new TestCase2(username, password)};
    }

    @DataProvider(name = "data", parallel = true)
    public Object[][] dataMethod() {
        return new Object[][]{
                {"user1", "password1"},
                {"user2", "password2"},
                {"user3", "password3"}
        };
    }


}
