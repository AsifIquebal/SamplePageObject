package automationPracticeParallel;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class TestBase {

    public String flag = "";// = true;

    @BeforeMethod
    public void setUp(Object[] data, ITestContext context, Method m) {
        //System.out.println("Before Method...setting up data for.." + params[0]);
        System.out.println("Dataset to run with...");
        for (Object o : data) {
            System.out.println("Data " + o);
        }
        //setFlag(params[0]);
        //System.out.println(context.getCurrentXmlTest());
        //System.out.println(context.getAttributeNames());
        //context.setAttribute("enable",false);
        //flag = true;

        //params[0].
    }

    public void setFlag(Object object) {
        System.out.println("Setting flag for " + object.toString());
        if (object.equals("user1")) {
            flag = "run";
            System.out.println(object + ", Flag: " + flag);
        } else if (object.equals("user2")) {
            flag = "Skip";
            System.out.println(object + ", Flag: " + flag);
        } else if (object.equals("user3")) {
            flag = "run";
            System.out.println(object + ", Flag: " + flag);
        }
    }

    public String getFlag(){
        return flag;
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
