package automationPracticeParallel;


import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MyTransformer /*extends TestBase*/ implements IAnnotationTransformer {

    // Do not worry about calling this method as testNG calls it behind the scenes before EVERY method (or test).
    // It will disable single tests, not the entire suite like SkipException
    /*public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

        // If we have chose not to run this test then disable it.
        if (disableMe()) {
            annotation.setEnabled(false);
        }
    }*/

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        System.out.println("Inside Transform");
        /*if("test002".equals(testMethod.getName())){

            System.out.println("Disabling Test: " + testMethod.getName());
            annotation.setEnabled(false);
        }*/
        /*if (disableMe()) {
            annotation.setEnabled(false);
        }*/
        /*if (!TestBase.flag) {
            annotation.setEnabled(false);
        }*/
    }

    // logic YOU control
    /*private boolean disableMe() {
        if (TestBase.flag) {
            System.out.println("Disable Test: " + TestBase.flag);
            return false;
        } else {
            System.out.println("Disable Test: " + TestBase.flag);
            return true;
        }
    }*/

}
